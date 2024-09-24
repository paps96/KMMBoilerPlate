package com.example.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Tracks (

  @SerialName("name"              ) var name              : String?           = null,
  @SerialName("posterUrl"         ) var posterUrl         : String?           = null,
  @SerialName("featuredPosterUrl" ) var featuredPosterUrl : String?           = null,
  @SerialName("albumId"           ) var albumId           : Int?              = null,
  @SerialName("phonogramId"       ) var phonogramId       : Int?              = null,
  @SerialName("albumName"         ) var albumName         : String?           = null,
  @SerialName("numTracks"         ) var numTracks         : Int?              = null,
  @SerialName("artistName"        ) var artistName        : ArrayList<String> = arrayListOf(),
  @SerialName("urlredirec"        ) var urlredirec        : String?           = null

)