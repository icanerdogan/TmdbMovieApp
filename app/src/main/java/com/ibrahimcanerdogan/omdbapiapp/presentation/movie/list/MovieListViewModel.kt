package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetSelectMovieUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.UpdateMoviesUseCase

class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies(pageNumber: Int, isScrolled: Boolean) : LiveData<List<Movie>?> = liveData {
        val movieList : List<Movie>? = getMoviesUseCase.execute(pageNumber, isScrolled)
        emit(movieList)
    }
    fun updateMovies(pageNumber: Int) : LiveData<List<Movie>?> =  liveData {
        val movieList: List<Movie>? = updateMoviesUseCase.execute(pageNumber)
        emit(movieList)
    }

}