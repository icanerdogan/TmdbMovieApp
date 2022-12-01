package com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasource

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(pageNumber: Int): Response<MovieList>
}