package org.paps96.reqres.MemoryManager


expect class SecureStorage {
    fun set(key: String, value: Any): Boolean
    fun string(forKey: String): String?
    fun int(forKey: String): Int?
    fun existsObject(forKey: String): Boolean
    fun allKeys(): List<String>
    fun removeObject(forKey: String): Boolean
    fun clear(): Boolean
}