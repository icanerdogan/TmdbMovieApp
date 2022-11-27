package com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}