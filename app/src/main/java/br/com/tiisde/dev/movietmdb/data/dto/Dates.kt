package br.com.tiisde.dev.movietmdb.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dates(
    @Json(name = "maximum")
    val maximum: String,
    @Json(name = "minimum")
    val minimum: String
)