package com.ibrahimcanerdogan.omdbapiapp.data.repository.movie

import android.util.Log
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieCacheDataSource
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieLocalDataSource
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.ibrahimcanerdogan.omdbapiapp.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(pageNumber: Int, isScrolled: Boolean): List<Movie> {
        return getMoviesFromCache(pageNumber, isScrolled)
    }

    override suspend fun updateMovies(pageNumber: Int): List<Movie> {
        val newListOfMovies = getMoviesFromAPI(pageNumber)
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    override suspend fun getSelectedMovie(selectedMovieID: Int): Movie {
        lateinit var movie: Movie

        try {
            movie = movieLocalDataSource.getOneMovieFromDB(selectedMovieID)
            Log.i(TAG, movie.toString())
        } catch (e: Exception){
            Log.e(TAG, e.message.toString())
        }

        return movie
    }

    suspend fun getMoviesFromAPI(pageNumber: Int): List<Movie> {
        lateinit var movieList: List<Movie>
        runBlocking {
            withContext(Dispatchers.IO) {
                try {
                    val response = movieRemoteDataSource.getMovies(pageNumber)
                    val body = response.body()
                    movieList = body?.movies ?: arrayListOf()
                    Log.i(TAG,movieList.toString())

                } catch (e: Exception){
                    Log.e(TAG,e.message.toString())
                }
            }
        }
        return movieList
    }

    suspend fun getMoviesFromDB(pageNumber: Int, isScrolled: Boolean): List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
            Log.i(TAG,movieList.toString())
        } catch (e: Exception){
            Log.e(TAG,e.message.toString())
        }

        if (movieList.isNotEmpty() && !isScrolled){
            return movieList
        }
        else {
            movieList = getMoviesFromAPI(pageNumber)
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(pageNumber: Int, isScrolled: Boolean) : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
            Log.i(TAG, movieList.toString())
        } catch (e: Exception){
            Log.e(TAG,e.message.toString())
        }

        if (movieList.isNotEmpty() && !isScrolled){
            return movieList
        }
        else{
            movieList = getMoviesFromDB(pageNumber, isScrolled)
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

    companion object {
        private const val TAG: String = "MovieRepositoryImpl"
    }
}