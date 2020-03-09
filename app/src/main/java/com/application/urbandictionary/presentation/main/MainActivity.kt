package com.application.urbandictionary.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.urbandictionary.AndroidApplication
import com.application.urbandictionary.R
import com.application.urbandictionary.di.ApplicationComponent

class MainActivity : AppCompatActivity() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment.newInstance())
                .commitNow()
        }
    }

}
