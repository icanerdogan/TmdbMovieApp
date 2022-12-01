package com.ibrahimcanerdogan.tmdbapp.presentation.movie.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.GetSelectMovieUseCase
class MovieDetailViewModelFactory(
    private val getSelectMovieUseCase: GetSelectMovieUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(getSelectMovieUseCase) as T
    }
}