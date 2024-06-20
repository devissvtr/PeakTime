package com.devissvtr.peaktime.ui.schedule

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devissvtr.peaktime.network.database.Schedule
import com.devissvtr.peaktime.repository.ScheduleRepository

class InputScheduleViewModel(application: Application): ViewModel() {
    private val repository: ScheduleRepository = ScheduleRepository(application)

    fun getAllNotes(): LiveData<List<Schedule>> = repository.getAllSchedule()
    fun insert(schedule: Schedule) {
        repository.insert(schedule)
    }
    fun remove(schedule: Schedule) {
        repository.remove(schedule)
    }
}