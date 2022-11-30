package com.ibrahimcanerdogan.omdbapiapp.domain.usecase

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.domain.repository.MovieRepository


class GetSelectMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(selectedMovieID: Int) : Movie = movieRepository.getSelectedMovie(selectedMovieID)
}