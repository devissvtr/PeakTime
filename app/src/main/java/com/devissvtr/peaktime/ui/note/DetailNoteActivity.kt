package com.devissvtr.peaktime.ui.note

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityDetailNoteBinding

class DetailNoteActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailNoteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//        intent.getParcelableExtra<...>(DETAIL_NOTE)?.let{
//            note -> with(binding) {
//                tvTitleNote.text = note.
//                tvDescriptionNote.text = note.
//            }
//        }
    }

    companion object {
        const val DETAIL_NOTE = "detail_note"
    }
}