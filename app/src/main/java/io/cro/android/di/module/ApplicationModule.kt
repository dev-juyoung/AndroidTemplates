package io.cro.android.di.module

import dagger.Module
import dagger.Provides
import io.cro.android.data.network.api.GitHubApi
import io.cro.android.data.source.user.UserDataSource
import io.cro.android.data.source.user.local.UserLocalDataSource
import io.cro.android.data.source.user.remote.UserRemoteDataSource
import io.cro.android.di.qualifier.UserLocalData
import io.cro.android.di.qualifier.UserRemoteData
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinds::class, NetworkModule::class])
object ApplicationModule {
    @JvmStatic
    @UserLocalData
    @Singleton
    @Provides
    fun provideUserLocalDataSource(): UserDataSource =
        UserLocalDataSource()

    @JvmStatic
    @UserRemoteData
    @Singleton
    @Provides
    fun provideUserRemoteDataSource(api: GitHubApi): UserDataSource =
        UserRemoteDataSource(api)
}
