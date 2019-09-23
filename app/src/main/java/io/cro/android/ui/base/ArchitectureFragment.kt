package io.cro.android.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class ArchitectureFragment<VM : BaseViewModel> : BaseFragment() {
    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory
    protected abstract val viewModel: VM

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.initialize()
        observeViewModel()
    }

    protected open fun observeViewModel() {
        /* no-op */
    }
}
