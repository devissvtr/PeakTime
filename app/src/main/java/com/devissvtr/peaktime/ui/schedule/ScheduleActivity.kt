package com.devissvtr.peaktime.ui.schedule

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.MainActivity
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityScheduleBinding

class ScheduleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fbAdd.setOnClickListener {
            val intent = Intent(this@ScheduleActivity, InputScheduleActivity::class.java)
            startActivity(intent)
        }
    }
}