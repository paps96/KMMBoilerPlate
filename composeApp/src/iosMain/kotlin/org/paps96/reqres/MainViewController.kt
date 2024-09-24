package org.paps96.reqres

import androidx.compose.ui.window.ComposeUIViewController
import org.paps96.reqres.MemoryManager.SecureStorage

fun MainViewController() = ComposeUIViewController {
    val secureStorage = SecureStorage()
    App(secureStorage)
}