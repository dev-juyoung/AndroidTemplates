package io.cro.android.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.cro.android.data.database.AppDatabase
import io.cro.android.data.network.api.GitHubApi
import io.cro.android.data.source.user.UserDataSource
import io.cro.android.data.source.user.local.UserLocalDataSource
import io.cro.android.data.source.user.remote.UserRemoteDataSource
import io.cro.android.di.qualifier.UserLocalData
import io.cro.android.di.qualifier.UserRemoteData
import io.cro.android.util.DATABASE_NAME
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinds::class, NetworkModule::class])
object ApplicationModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

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
