package com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasource

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)

}