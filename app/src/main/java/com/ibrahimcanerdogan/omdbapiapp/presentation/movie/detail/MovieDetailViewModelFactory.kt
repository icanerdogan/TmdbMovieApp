package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetSelectMovieUseCase
class MovieDetailViewModelFactory(
    private val getSelectMovieUseCase: GetSelectMovieUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(getSelectMovieUseCase) as T
    }
}