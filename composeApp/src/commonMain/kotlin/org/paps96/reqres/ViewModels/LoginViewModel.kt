package org.paps96.reqres.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError: StateFlow<String?> = _loginError

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun login(username: String, password: String) {
        _isLoading.value = true

        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)  // Simulación de red

            if (username == "speedymovil" && password == "speedymovil2024") {
                _loginSuccess.value = true
                _loginError.value = null
            } else {
                _loginError.value = "Usuario o contraseña incorrectos"
            }

            _isLoading.value = false
        }
    }

    fun clearError() {
        _loginError.value = null
    }
}