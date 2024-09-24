package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Banners (

  @SerialName("albumId"     ) var albumId     : String? = null,
  @SerialName("albumName"   ) var albumName   : String? = null,
  @SerialName("id"          ) var id          : Int?    = null,
  @SerialName("image"       ) var image       : String? = null,
  @SerialName("urlRedirect" ) var urlRedirect : String? = null

)