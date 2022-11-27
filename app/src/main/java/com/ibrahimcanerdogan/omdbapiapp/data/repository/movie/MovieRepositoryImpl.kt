package com.ibrahimcanerdogan.omdbapiapp.data.repository.movie

import android.util.Log
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieCacheDataSource
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieLocalDataSource
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.ibrahimcanerdogan.omdbapiapp.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            movieList = body?.movies ?: arrayListOf()
            Log.i(TAG,movieList.toString())

        } catch (e: Exception){
            Log.e(TAG,e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
            Log.i(TAG,movieList.toString())
        } catch (e: Exception){
            Log.e(TAG,e.message.toString())
        }

        if (movieList.isNotEmpty()){
            return movieList
        }
        else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
            Log.i(TAG, movieList.toString())
        } catch (e: Exception){
            Log.e(TAG,e.message.toString())
        }

        if (movieList.isNotEmpty()){
            return movieList
        }
        else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

    companion object {
        private const val TAG: String = "MovieRepositoryImpl"
    }
}