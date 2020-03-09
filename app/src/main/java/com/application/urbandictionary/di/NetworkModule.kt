package com.application.urbandictionary.di

import com.application.urbandictionary.data.Api
import com.application.urbandictionary.data.UrbanRepositoryImpl
import com.application.urbandictionary.di.annotation.ApplicationScoped
import com.application.urbandictionary.domain.UrbanRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @ApplicationScoped
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @ApplicationScoped
    @Provides
    fun getSearchDefinitions(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}