package com.ibrahimcanerdogan.omdbapiapp.domain.repository

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}