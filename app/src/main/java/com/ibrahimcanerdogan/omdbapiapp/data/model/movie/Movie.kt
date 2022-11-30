package com.ibrahimcanerdogan.omdbapiapp.data.model.movie

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_item")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val movieID: Int,
    @SerializedName("title")
    val movieTitle: String?,
    @SerializedName("release_date")
    val movieReleaseDate: String?,
    @SerializedName("poster_path")
    val moviePosterPath: String?,
    @SerializedName("backdrop_path")
    val movieBackdropPath: String?,
    @SerializedName("overview")
    val movieOverview: String?,
    @SerializedName("popularity")
    val moviePopularity: Double?,
    @SerializedName("vote_average")
    val movieVoteAverage: Double?,
)
