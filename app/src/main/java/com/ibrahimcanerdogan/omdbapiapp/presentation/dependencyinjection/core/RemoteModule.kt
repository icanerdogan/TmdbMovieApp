package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.core

import com.ibrahimcanerdogan.omdbapiapp.data.api.APIService
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(apiService: APIService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiService)
    }

}