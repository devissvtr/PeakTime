package com.devissvtr.peaktime.ui.prediction

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityPredictionBinding
import com.devissvtr.peaktime.network.retrofit.ApiService
import com.devissvtr.peaktime.repository.PredictionRepository

class PredictionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPredictionBinding
//    private val viewModel: PredictionViewModel by viewModels {
//        PredictionViewModelFactory(PredictionRepository(ApiService.create()))
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPredictionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}