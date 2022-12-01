package com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.core


import com.ibrahimcanerdogan.tmdbapp.domain.repository.MovieRepository
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.GetSelectMovieUseCase
import com.ibrahimcanerdogan.tmdbapp.domain.usecase.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetSelectMovieUseCase(movieRepository: MovieRepository): GetSelectMovieUseCase {
        return GetSelectMovieUseCase(movieRepository)
    }
}