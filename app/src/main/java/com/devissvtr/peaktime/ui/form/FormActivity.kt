package com.devissvtr.peaktime.ui.form

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityFormBinding
import com.devissvtr.peaktime.ui.form.FieldData.itemsQ1
import com.devissvtr.peaktime.ui.form.FieldData.itemsQ10
import com.devissvtr.peaktime.ui.form.FieldData.itemsQ3
import com.devissvtr.peaktime.ui.form.FieldData.itemsQ4
import com.devissvtr.peaktime.ui.form.FieldData.itemsQ5
import com.devissvtr.peaktime.ui.form.FieldData.itemsQ7
import com.devissvtr.peaktime.ui.form.FieldData.itemsQ8
import com.devissvtr.peaktime.repository.Result
import com.devissvtr.peaktime.ui.prediction.PredictionActivity

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    private val viewModel: FormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupAutoCompleteTextView()

        val userId = intent.getStringExtra("userId") ?: return

        binding.btnSubmit.setOnClickListener {
            submitForm()
        }
    }

    private fun setupAutoCompleteTextView() {
        val autoCompleteQ1: AutoCompleteTextView = findViewById(R.id.edt_field1)
        val adapterQ1 = ArrayAdapter(this, R.layout.list_form, itemsQ1)
        autoCompleteQ1.setAdapter(adapterQ1)

        val autoCompleteQ3: AutoCompleteTextView = findViewById(R.id.edt_field3)
        val adapterQ3 = ArrayAdapter(this, R.layout.list_form, itemsQ3)
        autoCompleteQ3.setAdapter(adapterQ3)

        val autoCompleteQ4: AutoCompleteTextView = findViewById(R.id.edt_field4)
        val adapterQ4 = ArrayAdapter(this, R.layout.list_form, itemsQ4)
        autoCompleteQ4.setAdapter(adapterQ4)

        val autoCompleteQ5: AutoCompleteTextView = findViewById(R.id.edt_field5)
        val adapterQ5 = ArrayAdapter(this, R.layout.list_form, itemsQ5)
        autoCompleteQ5.setAdapter(adapterQ5)

        val autoCompleteQ7: AutoCompleteTextView = findViewById(R.id.edt_field7)
        val adapterQ7 = ArrayAdapter(this, R.layout.list_form, itemsQ7)
        autoCompleteQ7.setAdapter(adapterQ7)

        val autoCompleteQ8: AutoCompleteTextView = findViewById(R.id.edt_field8)
        val adapterQ8 = ArrayAdapter(this, R.layout.list_form, itemsQ8)
        autoCompleteQ8.setAdapter(adapterQ8)

        val autoCompleteQ10: AutoCompleteTextView = findViewById(R.id.edt_field10)
        val adapterQ10 = ArrayAdapter(this, R.layout.list_form, itemsQ10)
        autoCompleteQ10.setAdapter(adapterQ10)
    }

    private fun dataForm(userId: String) {
        showLoad(true)

        val age = binding.edtAge.text.toString().toInt()
        val task = binding.edtField1.text.toString()
        val averageRest = binding.edtField2.text.toString().toInt()
        val moodBeforeWork = binding.edtField3.text.toString()
        val deadline = binding.edtField4.text.toString()
        val importance = binding.edtField5.text.toString().toInt()
        val sleepAverage = binding.edtField6.text.toString().toInt()
        val urgency = binding.edtField7.text.toString().toInt()
        val totalGangguan = binding.edtField8.text.toString().split(",").toTypedArray()
        val averageWorkHour = binding.edtField9.text.toString().toInt()
        val workDays = binding.edtField10.text.toString()

        if (age == 0 || task.isEmpty() || moodBeforeWork.isEmpty() || deadline.isEmpty() || importance == 0 || sleepAverage == 0 || urgency == 0 || totalGangguan.isEmpty() || averageWorkHour == 0 || workDays.isEmpty()) {
            Toast.makeText(this@FormActivity, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            showLoad(false)
        } else if (userId != null){
            viewModel.submitForm(
                userId,
                age,
                task,
                averageRest,
                moodBeforeWork,
                deadline,
                importance,
                sleepAverage,
                urgency,
                totalGangguan,
                averageWorkHour,
                workDays
            ).observe(this) {
                when (it) {
                    is Result.Loading-> {
                        showLoad(true)
                    }
                    is Result.Success -> {
                        showLoad(false)
                        val intent = Intent(this@FormActivity, PredictionActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                    is Result.Error -> {
                        showLoad(false)
                        Toast.makeText(this@FormActivity, "Form submitted failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun showLoad(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    fun submitForm() {
        val intent = Intent(this, PredictionActivity::class.java)
        startActivity(intent)
        finish()
    }
}