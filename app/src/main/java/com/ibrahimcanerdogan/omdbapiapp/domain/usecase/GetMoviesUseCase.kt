package com.ibrahimcanerdogan.omdbapiapp.domain.usecase

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.domain.repository.MovieRepository


class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(pageNumber: Int, isScrolled: Boolean) : List<Movie>? = movieRepository.getMovies(pageNumber, isScrolled)
}