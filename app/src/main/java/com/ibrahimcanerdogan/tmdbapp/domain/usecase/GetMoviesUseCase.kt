package com.ibrahimcanerdogan.tmdbapp.domain.usecase

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.Movie
import com.ibrahimcanerdogan.tmdbapp.domain.repository.MovieRepository


class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(pageNumber: Int, isScrolled: Boolean) : List<Movie>? = movieRepository.getMovies(pageNumber, isScrolled)
}