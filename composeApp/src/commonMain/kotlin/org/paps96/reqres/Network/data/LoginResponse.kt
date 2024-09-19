package org.paps96.reqres.Network.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String?,
    val id: Int?,
    val error: String?
)
