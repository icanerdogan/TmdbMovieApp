package com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.core

import android.content.Context
import androidx.room.Room
import com.ibrahimcanerdogan.tmdbapp.data.database.LocalDatabase
import com.ibrahimcanerdogan.tmdbapp.data.database.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context) : LocalDatabase {
        return Room.databaseBuilder(context, LocalDatabase::class.java, "client")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(localDatabase: LocalDatabase) : MovieDao {
        return localDatabase.movieDao()
    }
}