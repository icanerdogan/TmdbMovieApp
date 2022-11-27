package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection

import com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.movie.MovieSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}