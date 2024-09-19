package org.paps96.reqres.Network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.paps96.reqres.Network.data.LoginData
import org.paps96.reqres.Network.data.LoginResponse

class NetworkManager(
    private val client: HttpClient
) {
    suspend fun LoginService(url: String, jsonBody: LoginData): LoginResponse {
        return try {
            client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(jsonBody)
            }.body<LoginResponse>()
        } catch (e: ClientRequestException) {
            println("Error en la solicitud: ${e.response.status}")
            LoginResponse(error = "Error en petición", id = null, token = null)
        } catch (e: ServerResponseException) {
            println("Error del servidor: ${e.response.status}")
            LoginResponse(error = "Error en el servidor", id = null, token = null)
        } catch (e: RedirectResponseException) {
            println("Redirección no exitosa: ${e.response.status}")
            LoginResponse(error = "Redirección no exitosa", id = null, token = null)
        } catch (e: Exception) {
            println("Error general: ${e.message}")
            LoginResponse(error = "Error", id = null, token = null)
        }
    }
}