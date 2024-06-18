package com.devissvtr.peaktime.network.preference

data class FormData(
    val age: Int,
    val task: String,
    val average_rest: Int,
    val mood_before_work: String,
    val deadline: String,
    val importance: Int,
    val sleep_average: Int,
    val urgency: Int,
    val total_gangguan: List<String>,
    val average_work_hour: Int,
    val work_days: String
)
