package com.devissvtr.peaktime.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.devissvtr.peaktime.network.database.Schedule
import com.devissvtr.peaktime.network.database.ScheduleDao
import com.devissvtr.peaktime.network.database.ScheduleRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ScheduleRepository(application: Application) {
    private val mScheduleDao: ScheduleDao
    private val executorService: ExecutorService = Executors.newSingleThreadScheduledExecutor()

    init {
        val db = ScheduleRoomDatabase.getDatabase(application)
        mScheduleDao = db.scheduleDao()
    }

    fun getAllSchedule(): LiveData<List<Schedule>> = mScheduleDao.getAllSchedule()

    fun insert(schedule: Schedule) {
        executorService.execute { mScheduleDao.insert(schedule) }
    }
    fun remove(schedule: Schedule) {
        executorService.execute { mScheduleDao.remove(schedule) }
    }
}