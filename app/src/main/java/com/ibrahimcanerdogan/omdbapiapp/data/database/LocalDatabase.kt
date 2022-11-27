package com.ibrahimcanerdogan.omdbapiapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}