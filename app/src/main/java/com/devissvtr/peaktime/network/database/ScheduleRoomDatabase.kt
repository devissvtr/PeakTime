package com.devissvtr.peaktime.network.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Schedule::class], version = 1)
abstract class ScheduleRoomDatabase : RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: ScheduleRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): ScheduleRoomDatabase {
            if (INSTANCE == null) {
                synchronized(ScheduleRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ScheduleRoomDatabase::class.java, "databaseSchedule")
                        .build()
                }
            }
            return ScheduleRoomDatabase.INSTANCE as ScheduleRoomDatabase
        }
    }
}