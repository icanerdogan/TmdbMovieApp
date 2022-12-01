package com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.movie

import com.ibrahimcanerdogan.tmdbapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.GetSelectMovieUseCase
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.UpdateMoviesUseCase
import com.ibrahimcanerdogan.tmdbapp.presentation.movie.detail.MovieDetailViewModelFactory
import com.ibrahimcanerdogan.tmdbapp.presentation.movie.list.MovieListViewModelFactory
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