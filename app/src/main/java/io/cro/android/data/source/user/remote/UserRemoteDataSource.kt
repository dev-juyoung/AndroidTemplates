package io.cro.android.data.source.user.remote

import io.cro.android.data.entity.UserProfile
import io.cro.android.data.network.api.GitHubApi
import io.cro.android.data.source.user.UserDataSource
import io.reactivex.Single

class UserRemoteDataSource constructor(private val api: GitHubApi) : UserDataSource {
    override fun getUsers(): Single<List<UserProfile>> = api.getUsers()
}
