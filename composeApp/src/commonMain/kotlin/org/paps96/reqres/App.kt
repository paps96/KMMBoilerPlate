package org.paps96.reqres

import androidx.compose.runtime.*
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.paps96.reqres.MemoryManager.SecureStorage
import org.paps96.reqres.Network.NetworkManager
import org.paps96.reqres.ViewModels.LoginViewModel
import org.paps96.reqres.ViewModels.WelcomeScreenViewModel
import org.paps96.reqres.Views.LoginScreen
import org.paps96.reqres.Views.WelcomeScreen

@Composable
@Preview
fun App(secureStorage: SecureStorage) {
    var loggedIn by remember { mutableStateOf(secureStorage.existsObject("password")) }
    val client = remember {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    if (loggedIn) {
        val welcomeScreenViewModel = WelcomeScreenViewModel(NetworkManager(client))
        WelcomeScreen(welcomeScreenViewModel)
    } else {
        val loginViewModel = LoginViewModel()
        LoginScreen(
            loginViewModel,
            onLoginSuccess = {
                secureStorage.set("user", "yes")
                loggedIn = true
            }
        )
    }
}