package com.ibrahimcanerdogan.tmdbapp.presentation.movie.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.UpdateMoviesUseCase

class MovieListViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}