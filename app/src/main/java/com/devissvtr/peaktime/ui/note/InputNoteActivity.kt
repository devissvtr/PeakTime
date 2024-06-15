package com.devissvtr.peaktime.ui.note

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityInputNoteBinding
import com.devissvtr.peaktime.helper.DateHelper
import com.devissvtr.peaktime.helper.ViewModelFactory
import com.devissvtr.peaktime.network.database.Note

@Suppress("DEPRECATION")
class InputNoteActivity : AppCompatActivity() {
    private var activityInputNoteBinding: ActivityInputNoteBinding? = null
    private lateinit var inputNoteViewModel: InputNoteViewModel
    private val binding get() = activityInputNoteBinding

    companion object {
        const val EXTRA_NOTE = "extra_note"
        const val ALERT_DIALOG_CLOSE = 10
        const val ALERT_DIALOG_DELETE = 20
    }

    private var isEdit = false
    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityInputNoteBinding = ActivityInputNoteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        inputNoteViewModel = obtainViewModel(this@InputNoteActivity)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        if (note != null) {
            isEdit = true
        } else {
            note = Note()
        }

        val actionBarTitle: String
        val btnTitle: String

        if (isEdit) {

            actionBarTitle = getString(R.string.change)
            btnTitle = getString(R.string.update)

            if (note != null) {
                note?.let { note ->
                    binding?.edtTitle?.setText(note.title)
                    binding?.edtDescription?.setText(note.description)
                }
            }
        } else {
            actionBarTitle = getString(R.string.add)
            btnTitle = getString(R.string.save)
        }

        supportActionBar?.title = actionBarTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding?.btnSubmit?.text = btnTitle
        binding?.btnSubmit?.setOnClickListener{
            val title = binding?.edtTitle?.text.toString().trim()
            val description = binding?.edtDescription?.text.toString().trim()
            when{
                title.isEmpty() -> {
                    binding?.edtTitle?.error = getString(R.string.empty)
                }
                description.isEmpty() -> {
                    binding?.edtTitle?.error = getString(R.string.empty)
                }
                else -> {
                    note.let { note ->
                        note?.title = title
                        note?.description = description
                    }
                    if (isEdit) {
                        inputNoteViewModel.update(note as Note)
                        showToast(getString(R.string.changed))
                    }else {
                        note.let { note ->
                            note?.date = DateHelper.getDate()
                        }
                        inputNoteViewModel.insert(note as Note)
                        showToast(getString(R.string.changed))
                    }
                    finish()
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        activityInputNoteBinding = null
    }

    private fun obtainViewModel(activity: AppCompatActivity): InputNoteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(InputNoteViewModel::class.java)
    }
}