package io.cro.android.ui.root

import androidx.activity.viewModels
import io.cro.android.R
import io.cro.android.ui.base.ArchitectureActivity

class RootActivity : ArchitectureActivity<RootViewModel>() {
    override fun layoutResId(): Int = R.layout.activity_root
    override val viewModel: RootViewModel by viewModels { viewModelFactory }
}
