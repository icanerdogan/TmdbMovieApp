package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.databinding.ActivityMovieListItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setMovieList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ActivityMovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }


}
class MovieViewHolder(val binding: ActivityMovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie : Movie){
        binding.textViewMovieListTitle.text = movie.movieTitle
        binding.textViewMovieListRelease.text = movie.movieReleaseDate

        val posterURL : String = "https://image.tmdb.org/t/p/w500" + movie.moviePosterPath
        Glide.with(binding.imageViewMovieListPoster.context)
            .load(posterURL)
            .into(binding.imageViewMovieListPoster)
    }
}