package com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail

import androidx.lifecycle.ViewModel
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetSelectMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MovieDetailViewModel(
    private val getSelectMovieUseCase: GetSelectMovieUseCase
) : ViewModel() {

    fun getSelectedMovie(selectedMovieID: Int) = runBlocking {
        withContext(Dispatchers.IO) { getSelectMovieUseCase.execute(selectedMovieID) }
    }

}