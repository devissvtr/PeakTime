package com.devissvtr.peaktime.ui.form

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.devissvtr.peaktime.MainActivity
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityFormBinding
import com.devissvtr.peaktime.ui.form.FormData.itemsGender
import com.devissvtr.peaktime.ui.form.FormData.itemsQ1
import com.devissvtr.peaktime.ui.form.FormData.itemsQ10
import com.devissvtr.peaktime.ui.form.FormData.itemsQ3
import com.devissvtr.peaktime.ui.form.FormData.itemsQ4
import com.devissvtr.peaktime.ui.form.FormData.itemsQ5
import com.devissvtr.peaktime.ui.form.FormData.itemsQ7
import com.devissvtr.peaktime.ui.form.FormData.itemsQ8

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val autoCompleteGender : AutoCompleteTextView = findViewById(R.id.edt_gender)
        val adapterGender = ArrayAdapter(this, R.layout.list_form, itemsGender)
        autoCompleteGender.setAdapter(adapterGender)


        val autoCompleteQ1 : AutoCompleteTextView = findViewById(R.id.edt_field1)
        val adapterQ1 = ArrayAdapter(this, R.layout.list_form, itemsQ1)
        autoCompleteQ1.setAdapter(adapterQ1)


        val autoCompleteQ3 : AutoCompleteTextView = findViewById(R.id.edt_field3)
        val adapterQ3 = ArrayAdapter(this, R.layout.list_form, itemsQ3)
        autoCompleteQ3.setAdapter(adapterQ3)


        val autoCompleteQ4 : AutoCompleteTextView = findViewById(R.id.edt_field4)
        val adapterQ4 = ArrayAdapter(this, R.layout.list_form, itemsQ4)
        autoCompleteQ4.setAdapter(adapterQ4)


        val autoCompleteQ5 : AutoCompleteTextView = findViewById(R.id.edt_field5)
        val adapterQ5 = ArrayAdapter(this, R.layout.list_form, itemsQ5)
        autoCompleteQ5.setAdapter(adapterQ5)


        val autoCompleteQ7 : AutoCompleteTextView = findViewById(R.id.edt_field7)
        val adapterQ7 = ArrayAdapter(this, R.layout.list_form, itemsQ7)
        autoCompleteQ7.setAdapter(adapterQ7)


        val autoCompleteQ8 : AutoCompleteTextView = findViewById(R.id.edt_field8)
        val adapterQ8 = ArrayAdapter(this, R.layout.list_form, itemsQ8)
        autoCompleteQ8.setAdapter(adapterQ8)


        val autoCompleteQ10 : AutoCompleteTextView = findViewById(R.id.edt_field10)
        val adapterQ10 = ArrayAdapter(this, R.layout.list_form, itemsQ10)
        autoCompleteQ10.setAdapter(adapterQ10)

        binding.btnSubmit.setOnClickListener {
            val intent = Intent(this@FormActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}