package org.paps96.reqres.MemoryManager
import com.liftric.kvault.KVault

import android.content.Context

actual class SecureStorage(private val context: Context) {
    private val store = KVault(context, "fileTest")

    actual fun set(key: String, value: Any): Boolean {
        return when (value) {
            is String -> store.set(key, value)
            is Int -> store.set(key, value)
            is Float -> store.set(key, value)
            is Boolean -> store.set(key, value)
            else -> false // Manejo de tipos no soportados
        }
    }

    actual fun string(forKey: String): String? {
        return store.string(forKey)
    }

    actual fun int(forKey: String): Int? {
        return store.int(forKey)
    }

    actual fun existsObject(forKey: String): Boolean {
        return store.existsObject(forKey)
    }

    actual fun allKeys(): List<String> {
        return store.allKeys()
    }

    actual fun removeObject(forKey: String): Boolean {
        return true
    }

    actual fun clear(): Boolean {
        return store.clear()
    }
}