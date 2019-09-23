package io.cro.android.ui.root

import io.cro.android.data.source.user.UserDataSource
import io.cro.android.extensions.networkThread
import io.cro.android.ui.base.BaseViewModel
import io.reactivex.rxkotlin.addTo
import timber.log.Timber
import javax.inject.Inject

class RootViewModel @Inject constructor(
    private val userRepository: UserDataSource
) : BaseViewModel() {
    override fun initialize() {
        super.initialize()
        userRepository.getUsers()
            .networkThread()
            .subscribe { response, error ->
                if (error != null) Timber.e("error::${error.message}")
                else Timber.i("response::${response.size}, $response")
            }.addTo(compositeDisposable)
    }
}
