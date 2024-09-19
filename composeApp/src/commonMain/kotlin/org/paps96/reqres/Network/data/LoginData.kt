package org.paps96.reqres.Network.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginData(
    val email: String,
    val password: String
)
