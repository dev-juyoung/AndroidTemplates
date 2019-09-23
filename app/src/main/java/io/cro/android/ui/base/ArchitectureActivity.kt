package io.cro.android.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class ArchitectureActivity<VM : BaseViewModel> : BaseActivity() {
    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory
    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize()
        observeViewModel()
    }

    protected open fun observeViewModel() {
        /* no-op */
    }
}
