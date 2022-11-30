package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ibrahimcanerdogan.omdbapiapp.R
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.databinding.ActivityMovieListBinding
import com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.Injector
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail.MovieDetailActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieListActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieListViewModelFactory
    private lateinit var movieViewModel: MovieListViewModel

    private val movieList = ArrayList<Movie>()
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityMovieListBinding

    private var pageNumber: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieListViewModel::class.java]

        initRecyclerView()
        refreshList()
    }

    private fun initRecyclerView() {
        binding.recyclerMovieList.layoutManager = GridLayoutManager(this, 2)
        adapter = MovieAdapter(movieList)
        adapter.onClick = {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("SelectedMovieID", it.movieID)
            startActivity(intent)
        }
        binding.recyclerMovieList.adapter = adapter

        displayPopularMovies(1, false)

        binding.recyclerMovieList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastItem: Int = (binding.recyclerMovieList.layoutManager as GridLayoutManager).findLastVisibleItemPosition()

                if (lastItem > movieList.size * 0.90) {
                    pageNumber += 1
                    displayPopularMovies(pageNumber, true)
                }
            }
        })
    }

    private fun displayPopularMovies(pageNumber: Int, isScrolled: Boolean) {
        binding.progressBarMovieList.visibility = View.VISIBLE

        val responseLiveData: LiveData<List<Movie>?> = if (pageNumber != TOTAL_PAGES) {
            movieViewModel.getMovies(pageNumber, isScrolled)
        } else {
            movieViewModel.getMovies(pageNumber, !isScrolled)
        }

        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setMovieList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarMovieList.visibility = View.GONE
            } else {
                binding.progressBarMovieList.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Avaliable!", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun refreshList() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            adapter.notifyDataSetChanged()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
    companion object {
        private const val TOTAL_PAGES = 36088
    }
}