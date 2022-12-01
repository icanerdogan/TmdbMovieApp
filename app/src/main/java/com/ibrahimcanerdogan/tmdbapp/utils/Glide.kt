package com.ibrahimcanerdogan.tmdbapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide


object GlideUtils {

    fun setImagePoster(posterUrl: String?, context: Context, imageView: ImageView) {
        val posterURL = "https://image.tmdb.org/t/p/w500$posterUrl"
        Glide.with(context)
            .load(posterURL)
            .into(imageView)
    }

    fun setImageBackdrop(backdropURL: String?, context: Context, imageView: ImageView) {
        val backdropPosterURL = "https://image.tmdb.org/t/p/original$backdropURL"

        Glide.with(context)
            .load(backdropPosterURL)
            .into(imageView)
    }
}
