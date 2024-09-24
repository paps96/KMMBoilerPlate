package org.paps96.reqres.Views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(scrollBehavior: TopAppBarScrollBehavior, onSettingsClick: () -> Unit) {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(text = "My App")
        },
        actions = {
            IconButton(onClick = {
                showMenu = !showMenu
            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = androidx.compose.ui.graphics.Color.Gray
                )
            }

            DropdownMenu(
                expanded = showMenu,  // Controla si el menú está visible o no
                onDismissRequest = { showMenu = false }, // Lógica para ocultar el menú
            ) {
                DropdownMenuItem(
                    text = { Text("Cerrar Sesión") },
                    onClick = {
                        onSettingsClick()
                        showMenu = false // Oculta el menú al hacer clic
                        println("Opción 1 seleccionada")
                })
            }
        },
        scrollBehavior = scrollBehavior
    )
}