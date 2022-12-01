package com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasource

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun getOneMovieFromDB(selectedMovieID: Int): Movie
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}