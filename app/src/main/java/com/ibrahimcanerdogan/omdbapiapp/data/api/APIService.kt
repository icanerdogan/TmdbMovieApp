package com.ibrahimcanerdogan.omdbapiapp.data.api

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.MovieList
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("discover/movie?api_key=eeb5c133f7b9f02d885d6f90a2f5c910&language=en-US&page=1")
    suspend fun getAllMovieListFromApi(): Response<MovieList>

    //@GET("movie/{ID}?api_key=eeb5c133f7b9f02d885d6f90a2f5c910&language=en-US")
    //suspend fun getMovieDetailFromApi(@Path("ID") moveDetailID: Int): Single<MovieDetail>

}