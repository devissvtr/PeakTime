package com.devissvtr.peaktime.network.response

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class RegisterResponse(
    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("message")
    val message: String? = null

)