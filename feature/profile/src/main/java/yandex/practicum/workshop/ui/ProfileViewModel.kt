package yandex.practicum.workshop.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import yandex.practicum.workshop.data.User
import yandex.practicum.workshop.domain.GetUserUseCase
import yandex.practicum.workshop.UserPrefsManager
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    @Suppress("UNUSED_PARAMETER") userPrefsManager: UserPrefsManager
) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user = _user.asStateFlow()

    init {
        viewModelScope.launch {
            getUserUseCase().collect {
                _user.value = it
            }
        }
    }
}