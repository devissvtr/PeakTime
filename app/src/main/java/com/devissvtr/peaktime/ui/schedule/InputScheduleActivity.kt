package com.devissvtr.peaktime.ui.schedule

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityFormBinding
import com.devissvtr.peaktime.databinding.ActivityInputScheduleBinding
import com.devissvtr.peaktime.network.database.Schedule
import com.devissvtr.peaktime.repository.Result
import com.devissvtr.peaktime.ui.form.FormViewModel
import com.google.android.material.textfield.TextInputLayout

@Suppress("DEPRECATION")
class InputScheduleActivity : AppCompatActivity() {
    private lateinit var calendar: Calendar
    private lateinit var datePickerDialog: DatePickerDialog

    private var inputScheduleBinding: ActivityInputScheduleBinding? = null
    private lateinit var inputScheduleViewModel: InputScheduleViewModel
    private val binding get() = inputScheduleBinding
    private var schedule: Schedule? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inputScheduleBinding = ActivityInputScheduleBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        calendar = Calendar.getInstance()

        val startDay = findViewById<EditText>(R.id.edt_startDay)
        val startTime = findViewById<EditText>(R.id.edt_startTime)

        val finishDay = findViewById<EditText>(R.id.edt_finishDay)
        val finishTime = findViewById<EditText>(R.id.edt_finishTime)

        startDay.setOnClickListener { showDatePicker(startDay) }

        startTime.setOnClickListener { showTimePicker(startTime) }

        finishDay.setOnClickListener { showDatePicker(finishDay) }

        finishTime.setOnClickListener { showTimePicker(finishTime) }

        binding?.btnSubmit?.setOnClickListener {
            val title = binding?.edtTitle?.text.toString().trim()
            val description = binding?.edtDescription?.text.toString().trim()
            val startDayText = startDay.text.toString()
            val startTimeText = startTime.text.toString()
            val finishDateText = finishDay.text.toString()
            val finishTimeText = finishTime.text.toString()
            when {
                title.isEmpty() -> {
                    binding?.edtTitle?.error
                }
            }
            val resultIntent = Intent()
            resultIntent.putExtra("schedule", schedule)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun showDatePicker(editText: EditText) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
            val selectedDate = "$year-${month+1}-$day"
            editText.setText(selectedDate)
        }, year, month,day)
        datePickerDialog.show()
    }

    private fun showTimePicker(text: EditText) {
        val hours = Calendar.HOUR
        val minutes = Calendar.MINUTE
        val timePicker = TimePickerDialog(this, { _, hour, minute ->
            val format = String.format("%02d:%02d", hour, minute)
            text.setText(format)
        }, hours, minutes, true)
        timePicker.show()
    }

    private fun showLoad(isLoading: Boolean) {
        binding?.progressBar?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}