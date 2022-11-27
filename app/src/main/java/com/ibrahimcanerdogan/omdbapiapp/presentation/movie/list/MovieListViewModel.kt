package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.UpdateMoviesUseCase

class MovieListViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies() : LiveData<List<Movie>?> = liveData {
        val movieList : List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }
    fun updateMovies() : LiveData<List<Movie>?> =  liveData {
        val movieList: List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }
}