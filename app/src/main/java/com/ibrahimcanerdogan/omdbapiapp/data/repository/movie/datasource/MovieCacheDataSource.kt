package com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)

}