package com.application.urbandictionary.di

import com.application.urbandictionary.data.UrbanRepositoryImpl
import com.application.urbandictionary.domain.UrbanRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun provideTasksRepository(repo: UrbanRepositoryImpl): UrbanRepository
}