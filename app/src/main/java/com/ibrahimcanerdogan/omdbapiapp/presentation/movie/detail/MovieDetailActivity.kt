package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.databinding.ActivityMovieDetailBinding
import com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.Injector
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list.MovieListActivity
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list.MovieListViewModel
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list.MovieListViewModelFactory
import javax.inject.Inject

class MovieDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieDetailViewModelFactory
    private lateinit var movieViewModel: MovieDetailViewModel

    private lateinit var binding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieDetailViewModel::class.java]

        val selectedMovieID = intent.getIntExtra("SelectedMovieID", 0)
        val movie = movieViewModel.getSelectedMovie(selectedMovieID)

        val backdropPosterURL : String = "https://image.tmdb.org/t/p/original" + movie.movieBackdropPath
        Glide.with(binding.imageViewMovieDetailPoster.context)
            .load(backdropPosterURL)
            .into(binding.imageViewMovieDetailPoster)

        binding.textViewMovieDetailTitle.text = movie.movieTitle
        binding.textViewMovieDetailReleasedDate.text = movie.movieReleaseDate
        binding.textViewMovieDetailPopularity.text = movie.moviePopularity.toString()
        binding.textViewMovieDetailIMDB.text = movie.movieVoteAverage.toString()
        binding.textViewMovieDetailPlot.text = movie.movieOverview
    }
}