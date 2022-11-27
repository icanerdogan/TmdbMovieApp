package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.movie

import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.MovieList
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.UpdateMoviesUseCase
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list.MovieListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieListViewModelFactory {
        return MovieListViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}