package io.cro.android.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UserLocalData

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UserRemoteData
