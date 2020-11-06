package com.atilsamancioglu.retrofitkotlin.model

import com.google.gson.annotations.SerializedName

class BaseResponse<T> {

    @SerializedName("StatusCode") val statusCode: Int? = null
    @SerializedName("ResultMessage") val resultMessage: String? = null
    @SerializedName("ResultObject") val resultObject: T? = null

    val isSucceed: Boolean
        get() = statusCode == 200
}