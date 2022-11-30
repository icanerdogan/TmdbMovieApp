package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.movie


import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.detail.MovieDetailActivity
import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list.MovieListActivity
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

