package com.devissvtr.peaktime.ui.note

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityNoteBinding
import com.devissvtr.peaktime.ui.schedule.InputScheduleActivity

class NoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fbAdd.setOnClickListener {
            val intent = Intent(this@NoteActivity, InputNoteActivity::class.java)
            startActivity(intent)
        }
    }
}