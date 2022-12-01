package com.ibrahimcanerdogan.tmdbapp.domain.repository

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(pageNumber: Int, isScrolled: Boolean) : List<Movie>?
    suspend fun updateMovies(pageNumber: Int) : List<Movie>?
    suspend fun getSelectedMovie(selectedMovieID: Int): Movie
}