package com.devissvtr.peaktime.ui.form

import androidx.lifecycle.ViewModel
import com.devissvtr.peaktime.repository.FormRepository

class FormViewModel(private val repository: FormRepository) : ViewModel() {
    fun submitForm(userId: String, age: Int, task: String, averageRest: Int, moodBeforeWork: String, deadline: String, importance: Int, sleepAverage: Int, urgency: Int, totalGangguan: Array<String>, averageWorkHour: Int, workDays: String) =
        repository.formData(userId, age, task, averageRest, moodBeforeWork, deadline, importance, sleepAverage, urgency, totalGangguan, averageWorkHour, workDays)
}