package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.databinding.ActivityMovieListItemBinding
import com.ibrahimcanerdogan.omdbapiapp.utils.GlideUtils

class MovieAdapter(val movieList: ArrayList<Movie>): RecyclerView.Adapter<MovieViewHolder>() {

    var onClick : ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ActivityMovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
        holder.itemView.setOnClickListener {
            onClick?.invoke(movieList[position])
        }
    }

    fun setMovieList(movies: List<Movie>) {
        movieList.addAll(movies)
    }

}
class MovieViewHolder(val binding: ActivityMovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie : Movie) {
        binding.textViewMovieListTitle.text = movie.movieTitle
        binding.textViewMovieListRelease.text = movie.movieReleaseDate
        GlideUtils.setImagePoster(
            movie.moviePosterPath,
            binding.imageViewMovieListPoster.context,
            binding.imageViewMovieListPoster
        )
    }
}