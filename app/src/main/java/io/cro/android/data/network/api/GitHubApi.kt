package io.cro.android.data.network.api

import io.cro.android.data.entity.UserProfile
import io.reactivex.Single
import retrofit2.http.GET

interface GitHubApi {
    @GET("/users")
    fun getUsers(): Single<List<UserProfile>>
}
