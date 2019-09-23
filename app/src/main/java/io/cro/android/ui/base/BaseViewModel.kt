package io.cro.android.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    open fun initialize() {
        /* no-op */
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}