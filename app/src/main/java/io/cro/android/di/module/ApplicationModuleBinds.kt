package io.cro.android.di.module

import dagger.Binds
import dagger.Module
import io.cro.android.data.source.user.UserDataSource
import io.cro.android.data.source.user.UserRepository
import javax.inject.Singleton

@Module
abstract class ApplicationModuleBinds {
    @Singleton
    @Binds
    abstract fun bindRepository(repository: UserRepository): UserDataSource
}
