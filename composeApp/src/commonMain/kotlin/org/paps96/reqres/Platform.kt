package org.paps96.reqres

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform