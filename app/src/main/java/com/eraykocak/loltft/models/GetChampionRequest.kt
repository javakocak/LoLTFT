package com.eraykocak.loltft.models

import com.google.gson.annotations.SerializedName

class GetChampionRequest (
    @SerializedName("AppName") private val appName: String,
    @SerializedName("ApiKey") private val apiKey: String,
    @SerializedName("Language") private val language: String
    //@SerializedName("ChampionId") private val id: Int
)
