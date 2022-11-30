package com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasourceImpl

import com.ibrahimcanerdogan.omdbapiapp.data.database.MovieDao
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.*

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMoviesFromDB()
    }

    override suspend fun getOneMovieFromDB(selectedMovieID: Int): Movie {
        return movieDao.getOneMovieFromDB(selectedMovieID)
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMoviesToDB(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMoviesFromDB()
        }
    }

}