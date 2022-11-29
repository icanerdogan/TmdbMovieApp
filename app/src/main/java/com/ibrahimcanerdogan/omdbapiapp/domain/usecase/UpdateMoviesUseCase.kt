package com.ibrahimcanerdogan.omdbapiapp.domain.usecase

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(pageNumber: Int) : List<Movie>? = movieRepository.updateMovies(pageNumber)
}