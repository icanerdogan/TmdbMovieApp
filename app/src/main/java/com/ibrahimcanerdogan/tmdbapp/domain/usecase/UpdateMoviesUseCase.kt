package com.ibrahimcanerdogan.tmdbapp.domain.usecase

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.Movie
import com.ibrahimcanerdogan.tmdbapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(pageNumber: Int) : List<Movie>? = movieRepository.updateMovies(pageNumber)
}