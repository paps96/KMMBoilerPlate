package org.paps96.reqres.Network.data

import kotlinx.serialization.Serializable

@Serializable
data class SerializableWrapper<T>(
    val data: T
)
