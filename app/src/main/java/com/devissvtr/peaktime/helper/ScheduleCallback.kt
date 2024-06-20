package com.devissvtr.peaktime.helper

import androidx.recyclerview.widget.DiffUtil
import com.devissvtr.peaktime.network.database.Note
import com.devissvtr.peaktime.network.database.Schedule

class ScheduleCallback (private val oldSchedule: List<Schedule>, private val newSchedule: List<Schedule>) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldSchedule.size

    override fun getNewListSize(): Int = newSchedule.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldSchedule[oldItemPosition].id ==newSchedule[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldSchedule = oldSchedule[oldItemPosition]
        val newSchedule = newSchedule[newItemPosition]
        return oldSchedule.title == newSchedule.title && oldSchedule.description == newSchedule.description
    }
}