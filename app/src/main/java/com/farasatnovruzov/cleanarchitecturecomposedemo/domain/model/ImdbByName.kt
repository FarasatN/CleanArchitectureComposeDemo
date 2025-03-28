package com.farasatnovruzov.cleanarchitecturecomposedemo.domain.model

import com.google.gson.annotations.SerializedName

data class ImdbByName(
    @SerializedName("Poster")
    val Poster: String?,
    @SerializedName("Title")
    val Title: String?,
    @SerializedName("Type")
    val Type: String?,
    @SerializedName("Year")
    val Year: String?,
    @SerializedName("imdbID")
    val imdbID: String?
)
