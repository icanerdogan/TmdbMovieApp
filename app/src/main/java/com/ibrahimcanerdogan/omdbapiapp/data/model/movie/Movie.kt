package com.ibrahimcanerdogan.omdbapiapp.data.model.movie

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
)


/*
"adult": false,
"backdrop_path": "/bQXAqRx2Fgc46uCVWgoPz5L5Dtr.jpg",
"genre_ids": [
28,
14,
878
],
"id": 436270,
"original_language": "en",
"original_title": "Black Adam",
"overview": "Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods—and imprisoned just as quickly—Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.",
"popularity": 15075.276,
"poster_path": "/pFlaoHTZeyNkG83vxsAJiGzfSsa.jpg",
"release_date": "2022-10-19",
"title": "Black Adam",
"video": false,
"vote_average": 7.2,
"vote_count": 1888
}*/
