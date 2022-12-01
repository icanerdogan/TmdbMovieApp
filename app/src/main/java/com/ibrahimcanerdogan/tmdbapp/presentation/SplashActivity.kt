package com.ibrahimcanerdogan.tmdbapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ibrahimcanerdogan.tmdbapp.R
import com.ibrahimcanerdogan.tmdbapp.presentation.movie.list.MovieListActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Splash Screen
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this, MovieListActivity::class.java)
            startActivity(i)
            finish()
        }, 2000
        )
    }
}