package com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.core

import com.ibrahimcanerdogan.tmdbapp.data.repository.movie.MovieRepositoryImpl
import com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasource.MovieCacheDataSource
import com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasource.MovieLocalDataSource
import com.ibrahimcanerdogan.tmdbapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.ibrahimcanerdogan.tmdbapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
}