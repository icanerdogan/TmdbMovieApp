package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.movie


import com.ibrahimcanerdogan.omdbapiapp.presentation.movie.list.MovieListActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieListActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }

}

