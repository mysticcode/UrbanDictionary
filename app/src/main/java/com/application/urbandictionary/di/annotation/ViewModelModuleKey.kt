package com.application.urbandictionary.di.annotation

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelModuleKey(val value: KClass<out ViewModel>)
