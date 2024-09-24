package org.paps96.reqres.Views

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Screen(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val isDarkMode = isSystemInDarkTheme()
    val colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()
    MaterialTheme(colorScheme = colorScheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            content = content
        )
    }
}