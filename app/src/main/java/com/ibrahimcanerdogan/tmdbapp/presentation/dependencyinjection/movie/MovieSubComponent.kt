package com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.movie


import com.ibrahimcanerdogan.tmdbapp.presentation.movie.detail.MovieDetailActivity
import com.ibrahimcanerdogan.tmdbapp.presentation.movie.list.MovieListActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieListActivity: MovieListActivity)
    fun inject(movieDetailActivity: MovieDetailActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}

