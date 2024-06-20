package com.devissvtr.peaktime.network.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(schedule: Schedule)

    @Delete
    fun remove(schedule: Schedule)

    @Query("SELECT * from schedule ORDER BY id ASC")
    fun getAllSchedule(): LiveData<List<Schedule>>
}