package com.ibrahimcanerdogan.tmdbapp.presentation

import android.app.Application
import com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.Injector
import com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.core.*
import com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.movie.MovieSubComponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteModule(RemoteModule())
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

}