package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class TracksData (

  @SerialName("codigoRespuesta"  ) var codigoRespuesta  : Int?               = null,
  @SerialName("mensajeRespuesta" ) var mensajeRespuesta : String?            = null,
  @SerialName("banners"          ) var banners          : ArrayList<Banners> = arrayListOf(),
  @SerialName("tracks"           ) var tracks           : ArrayList<Tracks>  = arrayListOf()

)