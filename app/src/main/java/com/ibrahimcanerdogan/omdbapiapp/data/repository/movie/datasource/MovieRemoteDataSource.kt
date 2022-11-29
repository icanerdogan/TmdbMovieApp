package com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(pageNumber: Int): Response<MovieList>
}