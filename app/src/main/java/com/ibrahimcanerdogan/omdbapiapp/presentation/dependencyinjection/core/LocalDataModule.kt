package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.core

import com.ibrahimcanerdogan.omdbapiapp.data.database.MovieDao
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasource.MovieLocalDataSource
import com.ibrahimcanerdogan.omdbapiapp.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


// data > repository >  datasourceImpl içine baktığımızda fonksiyonlar DAO alıyor bizde onu vermemiz gerekiyor!
// Fonskiyonlar Impl'nin kullandığı interface dosyasını döndürüyor!
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

}