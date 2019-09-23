package io.cro.android

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.cro.android.di.DaggerApplicationComponent
import io.cro.android.extensions.isDebuggable
import timber.log.Timber

class RootApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        setupDevTools()
    }

    private fun setupDevTools() {
        if (!isDebuggable) return

        Timber.plant(Timber.DebugTree())
    }
}
