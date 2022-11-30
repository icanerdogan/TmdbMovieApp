package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.core


import com.ibrahimcanerdogan.omdbapiapp.domain.repository.MovieRepository
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetMoviesUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.GetSelectMovieUseCase
import com.ibrahimcanerdogan.omdbapiapp.domain.usecase.UpdateMoviesUseCase
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