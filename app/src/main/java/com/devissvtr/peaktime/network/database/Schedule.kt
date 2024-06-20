package com.devissvtr.peaktime.network.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Schedule(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "startDay")
    var startDay: String? = null,

    @ColumnInfo(name = "startTime")
    var startTime: String? = null,

    @ColumnInfo(name = "finishDay")
    var finishDay: String? = null,

    @ColumnInfo(name = "finishTime")
    var finishTime: String? = null
) : Parcelable
