package io.cro.android.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.cro.android.RootApplication
import io.cro.android.di.module.ApplicationModule
import io.cro.android.di.module.RootModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, AndroidSupportInjectionModule::class, RootModule::class])
interface ApplicationComponent : AndroidInjector<RootApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}
