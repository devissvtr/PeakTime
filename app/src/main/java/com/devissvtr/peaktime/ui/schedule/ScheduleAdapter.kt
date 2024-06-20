package com.devissvtr.peaktime.ui.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.helper.NoteCallback
import com.devissvtr.peaktime.helper.ScheduleCallback
import com.devissvtr.peaktime.network.database.Schedule
import com.devissvtr.peaktime.ui.schedule.ScheduleAdapter.ScheduleViewHolder

class ScheduleAdapter: RecyclerView.Adapter<ScheduleViewHolder>() {
    private val listSchedule = ArrayList<Schedule>()

    fun setListSchedules(lisSchedule: List<Schedule>) {
        val diffCallback = ScheduleCallback(this.listSchedule, lisSchedule)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listSchedule.clear()
        this.listSchedule.addAll(lisSchedule)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = listSchedule[position]
        holder.bind(schedule)
    }

    override fun getItemCount(): Int = listSchedule.size

    inner class ScheduleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvDay: TextView = itemView.findViewById(R.id.tvDay)
        private val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        private val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)

        fun bind(schedule: Schedule) {
            tvName.text = schedule.title
            tvDay.text = "Start: ${schedule.startDay}, End: ${schedule.finishDay}"
            tvTime.text = "Start: ${schedule.startTime}, End: ${schedule.finishTime}"
            tvDesc.text = schedule.description
        }
    }
}