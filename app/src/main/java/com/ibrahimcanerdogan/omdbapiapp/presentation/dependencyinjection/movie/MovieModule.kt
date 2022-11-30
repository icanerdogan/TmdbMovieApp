package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.movie

import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetSelectMovieUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.UpdateMoviesUseCase
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail.MovieDetailViewModelFactory
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list.MovieListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase,
    ): MovieListViewModelFactory {
        return MovieListViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }


    @MovieScope
    @Provides
    fun provideMovieDetailViewModelFactory(
        getSelectMovieUseCase: GetSelectMovieUseCase
    ): MovieDetailViewModelFactory {
        return MovieDetailViewModelFactory(
            getSelectMovieUseCase
        )
    }
}