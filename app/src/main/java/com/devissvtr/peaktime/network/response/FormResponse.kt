package com.devissvtr.peaktime.network.response

import com.google.gson.annotations.SerializedName

data class FormRequest (
    @field:SerializedName("age")
    val age: Int,

    @field:SerializedName("task")
    val task: String,

    @field:SerializedName("average_rest")
    val averageRest: Int,

    @field:SerializedName("mood_before_work")
    val moodWork: String,

    @field:SerializedName("deadline")
    val deadline: String,

    @field:SerializedName("importance")
    val importance: Int,

    @field:SerializedName("sleep_average")
    val sleepAverage: Int,

    @field:SerializedName("urgency")
    val urgency: Int,

    @field:SerializedName("total_gangguan")
    val totalGangguan: List<String>,

    @field:SerializedName("average_work_hour")
    val averageWork: Int,

    @field:SerializedName("work_days")
    val workDays: String
)

data class FormResponse (
    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("message")
    val message: String? = null
)
