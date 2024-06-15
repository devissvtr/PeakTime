package com.devissvtr.peaktime.ui.note

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devissvtr.peaktime.databinding.ActivityNoteBinding
import com.devissvtr.peaktime.helper.ViewModelFactory

class NoteActivity : AppCompatActivity() {
    private var activityNoteBinding: ActivityNoteBinding? = null
    private val binding get() = activityNoteBinding

    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityNoteBinding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(activityNoteBinding?.root)

        adapter = NoteAdapter()

        binding?.rvNote?.layoutManager = LinearLayoutManager(this)
        binding?.rvNote?.setHasFixedSize(true)
        binding?.rvNote?.adapter = adapter

        val mainViewModel = obtainViewModel(this@NoteActivity)
        mainViewModel.getAllNotes().observe(this) { noteList ->
            if (noteList != null) {
                adapter.setListNotes(noteList)
            }
        }

        binding?.fbAdd?.setOnClickListener {
            val intent = Intent(this@NoteActivity, InputNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun obtainViewModel(activity: NoteActivity): InputNoteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[InputNoteViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        activityNoteBinding = null
    }
}