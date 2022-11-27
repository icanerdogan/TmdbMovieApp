package com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.core

import android.content.Context
import com.ibrahimcanerdogan.omdbapiapp.presentation.dependencyinjection.movie.MovieSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }





}