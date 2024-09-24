package org.paps96.reqres.Views

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.paps96.reqres.ViewModels.LoginViewModel
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onLoginSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginSuccess by loginViewModel.loginSuccess.collectAsState()
    val loginError by loginViewModel.loginError.collectAsState()
    val isLoading by loginViewModel.isLoading.collectAsState()

    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            onLoginSuccess()
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = { newText ->
                    val filteredText = newText.filter { it.isLetterOrDigit() || it.isWhitespace() }
                    username = filteredText
                },
                label = { Text("Usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.None,
                    false,
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        coroutineScope.launch {
                            focusRequester.requestFocus()
                        }
                    }
                ),
                interactionSource = remember { MutableInteractionSource() }.also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect { interaction ->
                            if (interaction is DragInteraction.Start) {

                            }
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { newText ->
                    val filteredText = newText.filter { it.isLetterOrDigit() || it.isWhitespace() }
                    password = filteredText },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.None,
                    false,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                        if (username.isEmpty()) {
                            return@KeyboardActions
                        }
                        loginViewModel.login(username, password)
                    }
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { loginViewModel.login(username, password) },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                Text("Iniciar Sesión")
            }

            loginError?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }
        }
    }
}
