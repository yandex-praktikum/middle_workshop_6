package yandex.practicum.workshop.ui

import androidx.lifecycle.ViewModel
import yandex.practicum.workshop.data.User
import yandex.practicum.workshop.domain.SaveUserUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(
     private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    suspend fun saveUser(name: String) {
        saveUserUseCase.invoke(User(name))
    }
}