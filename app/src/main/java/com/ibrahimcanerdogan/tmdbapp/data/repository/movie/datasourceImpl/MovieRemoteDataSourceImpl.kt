package com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasourceImpl

import com.ibrahimcanerdogan.tmdbapp.data.api.APIService
import com.ibrahimcanerdogan.tmdbapp.data.model.movie.MovieList
import com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val apiService: APIService) : MovieRemoteDataSource {

    override suspend fun getMovies(pageNumber: Int): Response<MovieList> {
        return apiService.getAllMovieListFromApi(pageNumber)
    }

}