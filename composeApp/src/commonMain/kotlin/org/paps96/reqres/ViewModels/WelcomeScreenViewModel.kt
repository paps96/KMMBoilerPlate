package org.paps96.reqres.ViewModels

import androidx.lifecycle.ViewModel
import com.example.example.TracksData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.paps96.reqres.Network.NetworkManager

class WelcomeScreenViewModel(
    private val networkManager: NetworkManager
): ViewModel() {

    private val _tracksData = MutableStateFlow<TracksData?>(null)
    val tracksData: StateFlow<TracksData?> = _tracksData

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        _isLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = networkManager.fetchTracks()
                _tracksData.value = data
            } catch (e: Exception) {
                println("Error al cargar los datos: ${e.message}")
            }
            _isLoading.value = false
        }
    }

}