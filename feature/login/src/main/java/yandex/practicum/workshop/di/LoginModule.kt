package yandex.practicum.workshop.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import yandex.practicum.workshop.ui.LoginViewModel

@Module
abstract class LoginModule {

    @Binds
    abstract fun bindsViewModel(viewModel: LoginViewModel): ViewModel
}

