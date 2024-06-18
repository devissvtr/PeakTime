package com.devissvtr.peaktime.network.response

import com.google.gson.annotations.SerializedName

data class ScheduleRequest(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("startDay")
    val startDay: String,

    @field:SerializedName("finishDay")
    val finishDay: String?,

    @field:SerializedName("startTime")
    val startTime: String,

    @field:SerializedName("finishTime")
    val finishTime: String
)

data class ScheduleResponse(
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: ScheduleData
)

data class ScheduleData (
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("fkUserIdEvents")
    val fkUserIdEvents: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("startDay")
    val startDay: String,

    @field:SerializedName("finishDay")
    val finishDay: String,

    @field:SerializedName("startTime")
    val startTime: String,

    @field:SerializedName("finishTime")
    val finishTime: String,

    @field:SerializedName("finishStatus")
    val finishStatus: Int,

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("updatedAt")
    val updatedAt: String
)