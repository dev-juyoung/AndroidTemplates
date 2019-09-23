package io.cro.android.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.cro.android.di.ViewModelBuilder
import io.cro.android.di.ViewModelKey
import io.cro.android.ui.root.RootActivity
import io.cro.android.ui.root.RootViewModel

@Module
abstract class RootModule {
    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun rootActivity(): RootActivity

    @Binds
    @IntoMap
    @ViewModelKey(RootViewModel::class)
    abstract fun bindViewModel(viewModel: RootViewModel): ViewModel
}
