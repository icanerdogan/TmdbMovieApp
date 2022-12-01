package com.ibrahimcanerdogan.tmdbapp.domain.usecase

import com.ibrahimcanerdogan.tmdbapp.data.model.movie.Movie
import com.ibrahimcanerdogan.tmdbapp.domain.repository.MovieRepository


class GetSelectMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(selectedMovieID: Int) : Movie = movieRepository.getSelectedMovie(selectedMovieID)
}