package com.application.urbandictionary

import android.app.Application
import com.application.urbandictionary.di.ApplicationComponent
import com.application.urbandictionary.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    val component: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationContext(applicationContext)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectDI()
    }

    private fun injectDI() = component.inject(this)
}