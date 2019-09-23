package io.cro.android.data.source.user

import io.cro.android.data.network.entity.UserProfile
import io.cro.android.di.qualifier.UserLocalData
import io.cro.android.di.qualifier.UserRemoteData
import io.reactivex.Single
import javax.inject.Inject

class UserRepository @Inject constructor(
    @UserLocalData private val localData: UserDataSource,
    @UserRemoteData private val remoteData: UserDataSource
) : UserDataSource {
    override fun getUsers(): Single<List<UserProfile>> = remoteData.getUsers()
}
