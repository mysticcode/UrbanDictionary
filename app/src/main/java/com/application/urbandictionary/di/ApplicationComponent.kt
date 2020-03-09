package com.application.urbandictionary.di

import android.content.Context
import com.application.urbandictionary.AndroidApplication
import com.application.urbandictionary.presentation.main.MainActivity
import com.application.urbandictionary.di.annotation.ApplicationScoped
import com.application.urbandictionary.presentation.main.ListFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScoped
@Component(
    modules = [
        ViewModelModule::class, DomainModule::class, DataModule::class, NetworkModule::class]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: AndroidApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: ListFragment)
}