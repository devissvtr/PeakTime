package com.devissvtr.peaktime.network.response

import com.google.gson.annotations.SerializedName

data class FormResponse (
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String
)
