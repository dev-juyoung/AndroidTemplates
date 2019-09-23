package io.cro.android.data.source.user

import io.cro.android.data.entity.UserProfile
import io.reactivex.Single

interface UserDataSource {
    fun getUsers(): Single<List<UserProfile>>
}
