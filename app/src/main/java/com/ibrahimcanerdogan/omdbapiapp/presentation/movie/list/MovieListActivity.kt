package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.omdbapiapp.R
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.databinding.ActivityMovieListBinding
import com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.Injector
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail.MovieDetailActivity
import com.ibrahimcanerdogan.omdbapiapp.utils.InternetChecker
import javax.inject.Inject

class MovieListActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieListViewModelFactory
    private lateinit var movieViewModel: MovieListViewModel

    private val movieList = ArrayList<Movie>()
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityMovieListBinding

    private lateinit var searchView: SearchView

    private var pageNumber: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieListViewModel::class.java]

        initRecyclerView()
        loadMoviesWithInternet(1, false)
        refreshList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)
        val menuItem: MenuItem = menu.findItem(R.id.search_menu)

        searchView = menuItem.actionView as SearchView
        searchView.maxWidth = Integer.MAX_VALUE
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.search_menu -> {
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun initRecyclerView() {
        adapter = MovieAdapter(movieList)
        adapter.setHasStableIds(true)
        adapter.onClick = {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("SelectedMovieID", it.movieID)
            startActivity(intent)
        }

        val recyclerView = binding.recyclerMovieList
        recyclerView.isNestedScrollingEnabled = false;
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        recyclerView.hasFixedSize()
        recyclerView.setItemViewCacheSize(20);
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastItem: Int =
                    (binding.recyclerMovieList.layoutManager as GridLayoutManager).findLastVisibleItemPosition()

                if (lastItem > movieList.size * 0.90) {
                    pageNumber += 1
                    loadMoviesWithInternet(pageNumber, true)
                }
            }
        })
    }

    private fun loadMovies(pageNumber: Int, isScrolled: Boolean) {
        val progressBar = binding.progressBarMovieList
        progressBar.visibility = View.VISIBLE

        val responseLiveData: LiveData<List<Movie>?> = if (pageNumber != TOTAL_PAGES) {
            movieViewModel.getMovies(pageNumber, isScrolled)
        } else {
            movieViewModel.getMovies(pageNumber, !isScrolled)
        }

        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setMovieList(it)
                adapter.filter.filter(searchView.query)
                progressBar.visibility = View.GONE
            } else {
                progressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loadMoviesWithInternet(pageNumber: Int, isScrolled: Boolean) {
        if (InternetChecker.checkInternet(this)) {
            loadMovies(pageNumber, isScrolled)
        }
    }

    private fun refreshList() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            adapter.filter.filter(searchView.query)
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    companion object {
        private const val TOTAL_PAGES = 36088
    }
}