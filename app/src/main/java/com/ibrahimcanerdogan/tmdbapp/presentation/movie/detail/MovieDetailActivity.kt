package com.ibrahimcanerdogan.tmdbapp.presentation.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.tmdbapp.databinding.ActivityMovieDetailBinding
import com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.Injector
import com.ibrahimcanerdogan.tmdbapp.utils.GlideUtils
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
        setDetailData(selectedMovieID)
    }

    private fun setDetailData(selectedMovieID: Int) {
        val movie = movieViewModel.getSelectedMovie(selectedMovieID)

        GlideUtils.setImageBackdrop(movie.movieBackdropPath,
            binding.imageViewMovieDetailPoster.context,
            binding.imageViewMovieDetailPoster
        )

        binding.textViewMovieDetailTitle.text = movie.movieTitle
        binding.textViewMovieDetailReleasedDate.text = movie.movieReleaseDate
        binding.textViewMovieDetailPopularity.text = movie.moviePopularity.toString()
        binding.textViewMovieDetailIMDB.text = movie.movieVoteAverage.toString()
        binding.textViewMovieDetailPlot.text = movie.movieOverview
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}