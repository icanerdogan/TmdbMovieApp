package com.ibrahimcanerdogan.tmdbapp.data.api

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("discover/movie?api_key=eeb5c133f7b9f02d885d6f90a2f5c910&language=en-US")
    suspend fun getAllMovieListFromApi(@Query("page") pageNumber: Int): Response<MovieList>
    
}