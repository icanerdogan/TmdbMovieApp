package com.ibrahimcanerdogan.omdbapiapp.domain.repository

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(pageNumber: Int, isScrolled: Boolean) : List<Movie>?
    suspend fun updateMovies(pageNumber: Int) : List<Movie>?
    suspend fun getSelectedMovie(selectedMovieID: Int): Movie
}