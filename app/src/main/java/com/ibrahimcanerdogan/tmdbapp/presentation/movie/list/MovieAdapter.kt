package com.ibrahimcanerdogan.tmdbapp.presentation.movie.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.tmdbapp.data.model.movie.Movie
import com.ibrahimcanerdogan.tmdbapp.databinding.ActivityMovieListItemBinding
import com.ibrahimcanerdogan.tmdbapp.utils.GlideUtils

class MovieAdapter(private var movieList: ArrayList<Movie>) : RecyclerView.Adapter<MovieViewHolder>(), Filterable {

    var onClick: ((Movie) -> Unit)? = null
    private var filteredList: ArrayList<Movie> = ArrayList()

    init {
        filteredList = movieList
    }

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

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(text: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (text.isNullOrEmpty()) {
                    filterResults.values = filteredList
                    filterResults.count = filteredList.size
                } else {
                    val searchText = text.toString().lowercase()
                    val filteredMovieList: ArrayList<Movie> = ArrayList()
                    for (movie in filteredList) {
                        if (movie.movieTitle!!.lowercase().contains(searchText)) {
                            filteredMovieList.add(movie)
                        }
                    }
                    filterResults.values = filteredMovieList
                    filterResults.count = filteredMovieList.size
                }
                return filterResults
            }

            override fun publishResults(text: CharSequence?, filterResults: FilterResults?) {
                movieList = filterResults!!.values as ArrayList<Movie>
                notifyDataSetChanged()
            }
        }
    }

}

class MovieViewHolder(private val binding: ActivityMovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.textViewMovieListTitle.text = movie.movieTitle
        binding.textViewMovieListRelease.text = movie.movieReleaseDate
        GlideUtils.setImagePoster(
            movie.moviePosterPath,
            binding.imageViewMovieListPoster.context,
            binding.imageViewMovieListPoster
        )
    }
}