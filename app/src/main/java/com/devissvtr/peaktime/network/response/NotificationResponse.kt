package com.devissvtr.peaktime.network.response

import com.google.gson.annotations.SerializedName


data class NotificationRequest(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("description")
    val description: String
)

data class NotificationResponse (
    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: NotificationData
)

data class NotificationData(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("fkUserIdNotifications")
    val userIdNotifications: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("createdAt")
    val createdAt: String
)