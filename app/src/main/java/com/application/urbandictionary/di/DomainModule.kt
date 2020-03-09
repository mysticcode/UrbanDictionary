package com.application.urbandictionary.di

import com.application.urbandictionary.domain.GetListOfDefinitionsUseCase
import com.application.urbandictionary.domain.UrbanRepository
import dagger.Module
import dagger.Provides

@Module
object DomainModule {

    @Provides
    @JvmStatic
    fun provideGetListOfDefinitions(urbanRepo: UrbanRepository): GetListOfDefinitionsUseCase =
        GetListOfDefinitionsUseCase(urbanRepo)
}