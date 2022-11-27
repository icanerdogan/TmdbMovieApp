package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahimcanerdogan.omdbapiapp.R
import com.ibrahimcanerdogan.omdbapiapp.databinding.ActivityMovieListBinding
import com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.Injector
import javax.inject.Inject

class MovieListActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieListViewModelFactory
    private lateinit var movieViewModel: MovieListViewModel

    private lateinit var adapter: MovieAdapter
    private lateinit var binding : ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieListViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerMovieList.layoutManager = GridLayoutManager(this, 2)
        adapter = MovieAdapter()
        binding.recyclerMovieList.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.progressBarMovieList.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()

        responseLiveData.observe(this, Observer{
            if(it != null){
                adapter.setMovieList(it)
                adapter.notifyDataSetChanged()
                binding.progressBarMovieList.visibility = View.GONE
            }else{
                binding.progressBarMovieList.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Avaliable!", Toast.LENGTH_LONG).show()
            }
        })
    }


}