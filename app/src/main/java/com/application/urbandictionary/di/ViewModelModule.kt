package com.application.urbandictionary.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.application.urbandictionary.di.annotation.ViewModelModuleKey
import com.application.urbandictionary.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelModuleKey(MainViewModel::class)
    abstract fun bindTaskListViewModel(taskListViewModel: MainViewModel): ViewModel
}