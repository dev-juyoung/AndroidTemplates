package io.cro.android.data.source.user.local

import io.cro.android.data.entity.UserProfile
import io.cro.android.data.source.user.UserDataSource
import io.reactivex.Single

class UserLocalDataSource : UserDataSource {
    override fun getUsers(): Single<List<UserProfile>> = Single.never()
}
