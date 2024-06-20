package com.devissvtr.peaktime.ui.schedule

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.devissvtr.peaktime.MainActivity
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityScheduleBinding
import com.devissvtr.peaktime.network.database.Schedule

class ScheduleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleBinding
    private val schedules = mutableListOf<Schedule>()
    private lateinit var scheduleAdapter: ScheduleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //scheduleAdapter = ScheduleAdapter(schedules)
        binding.rvFavUser.layoutManager = LinearLayoutManager(this)
        binding.rvFavUser.adapter = scheduleAdapter

        binding.fbAdd.setOnClickListener {
            val intent = Intent(this@ScheduleActivity, InputScheduleActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_SCHEDULE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == REQUEST_CODE_ADD_SCHEDULE && resultCode == Activity.RESULT_OK) {
            val newSchedule = data?.getSerializableExtra("schedule") as? Schedule
            newSchedule?.let {
                schedules.add(it)
                scheduleAdapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_SCHEDULE = 1
    }
}