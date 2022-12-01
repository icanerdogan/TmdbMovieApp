package com.ibrahimcanerdogan.tmdbapp.presentation.dependencyinjection.core

import com.ibrahimcanerdogan.tmdbapp.data.api.APIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : APIService {
        return retrofit.create(APIService::class.java)
    }
}