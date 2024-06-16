package com.devissvtr.peaktime.ui.form

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.devissvtr.peaktime.MainActivity
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val itemsGender = listOf("Male", "Female")
        val autoCompleteGender : AutoCompleteTextView = findViewById(R.id.edt_gender)
        val adapterGender = ArrayAdapter(this, R.layout.list_form, itemsGender)

        autoCompleteGender.setAdapter(adapterGender)

        val itemsQ1 = listOf("Creative (Graphic design, Writer, etc.)",
            "Analytical (Data analysis, Financial analysis, etc.)",
            "Physical (Soccer player, Volleyball player, Laborer, etc.)",
            "Administrative (Admin, Secretary, etc.)",
            "Communication (Journalist, Broadcaster, Public Relations, etc.)",
            "Research (Environmental researchers, Cultural researchers, Data scientists, etc.)",
            "Academic (Lecturers, Teachers, Students, Students, etc.)")
        val autoCompleteQ1 : AutoCompleteTextView = findViewById(R.id.edt_field1)
        val adapterQ1 = ArrayAdapter(this, R.layout.list_form, itemsQ1)

        autoCompleteQ1.setAdapter(adapterQ1)

        val itemsQ3 = listOf("Enthusiasm",
            "Anxious",
            "Lazy")
        val autoCompleteQ3 : AutoCompleteTextView = findViewById(R.id.edt_field3)
        val adapterQ3 = ArrayAdapter(this, R.layout.list_form, itemsQ3)

        autoCompleteQ3.setAdapter(adapterQ3)

        val itemsQ4 = listOf("Less than 3 days",
            "3 days to 1 week",
            "1 to 2 weeks",
            "2 weeks to 1 month",
            "More than 1 month")
        val autoCompleteQ4 : AutoCompleteTextView = findViewById(R.id.edt_field4)
        val adapterQ4 = ArrayAdapter(this, R.layout.list_form, itemsQ4)

        autoCompleteQ4.setAdapter(adapterQ4)

        val itemsQ5 = listOf("Very important",
            "Important",
            "Neutral",
            "Not important",
            "Very at all important")
        val autoCompleteQ5 : AutoCompleteTextView = findViewById(R.id.edt_field5)
        val adapterQ5 = ArrayAdapter(this, R.layout.list_form, itemsQ5)

        autoCompleteQ5.setAdapter(adapterQ5)

        val itemsQ7 = listOf("Very urgent",
            "Urgent",
            "Neutral",
            "Not urgent",
            "Very at all urgent")
        val autoCompleteQ7 : AutoCompleteTextView = findViewById(R.id.edt_field7)
        val adapterQ7 = ArrayAdapter(this, R.layout.list_form, itemsQ7)

        autoCompleteQ7.setAdapter(adapterQ7)

        val itemsQ8 = listOf("Phone Call",
            "Disturbance from friends or coworkers",
            "Disturbance from superiors",
            "Disturbance from the surrounding environment (noise)",
            "Disturbance from electronic devices (notifications from smartphone or computer)",
            "Internal disturbance (Fatigue, hunger, thirst)",
            "Health disturbance")
        val autoCompleteQ8 : AutoCompleteTextView = findViewById(R.id.edt_field8)
        val adapterQ8 = ArrayAdapter(this, R.layout.list_form, itemsQ8)

        autoCompleteQ8.setAdapter(adapterQ8)

        val itemsQ10 = listOf("1 day",
            "2 days",
            "3 days",
            "4 days",
            "5 days",
            "6 days",
            "7 days")
        val autoCompleteQ10 : AutoCompleteTextView = findViewById(R.id.edt_field10)
        val adapterQ10 = ArrayAdapter(this, R.layout.list_form, itemsQ10)

        autoCompleteQ10.setAdapter(adapterQ10)

        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this@FormActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}