package com.devissvtr.peaktime.ui.prediction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devissvtr.peaktime.MainActivity
import com.devissvtr.peaktime.databinding.ActivityPredictionBinding

class PredictionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPredictionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPredictionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.cardView.setOnClickListener {
            val intent = Intent(this@PredictionActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}