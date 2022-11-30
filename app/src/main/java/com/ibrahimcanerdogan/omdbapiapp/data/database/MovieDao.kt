package com.ibrahimcanerdogan.omdbapiapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.omdbapiapp.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMoviesToDB(movies : List<Movie>)

    @Query(value = "DELETE FROM movie_item")
    suspend fun deleteAllMoviesFromDB()

    @Query(value = "SELECT * FROM movie_item")
    suspend fun getAllMoviesFromDB(): List<Movie>

    @Query(value = "SELECT * FROM movie_item WHERE movieID=:selectedMovieID")
    suspend fun getOneMovieFromDB(selectedMovieID: Int): Movie
}