package com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection

import com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.movie.MovieSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}