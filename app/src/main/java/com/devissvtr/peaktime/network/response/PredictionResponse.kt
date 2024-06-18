package com.devissvtr.peaktime.network.response

import com.google.gson.annotations.SerializedName

data class PredictionResponse (
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: PredictionData
)

data class PredictionData(
    @field:SerializedName("chronotype")
    val chronotype: String,

    @field:SerializedName("maxProbability")
    val maxProbability: Double
)
data class PredictionResult(
    @field:SerializedName("chronotype")
    val chronotype: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("percentage")
    val percentage: String,

    @field:SerializedName("workStartTime")
    val workStartTime: String,

    @field:SerializedName("workFinishTime")
    val workFinishTime: String,

    @field:SerializedName("wakeUpTime")
    val wakeUpTime: String,

    @field:SerializedName("sleepTime")
    val sleepTime: String
)