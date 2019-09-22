package io.cro.android

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.cro.android.di.DaggerApplicationComponent

class RootApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}
