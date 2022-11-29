package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>("movie")
        if (movie != null) {
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
}