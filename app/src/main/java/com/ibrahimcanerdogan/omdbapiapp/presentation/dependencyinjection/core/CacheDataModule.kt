package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.core

import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieCacheDataSource
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

}