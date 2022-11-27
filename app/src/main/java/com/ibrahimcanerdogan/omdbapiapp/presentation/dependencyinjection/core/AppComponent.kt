package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.core

import com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.movie.MovieSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

}