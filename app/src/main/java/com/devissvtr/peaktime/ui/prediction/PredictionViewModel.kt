package com.devissvtr.peaktime.ui.prediction

import androidx.lifecycle.ViewModel
import com.devissvtr.peaktime.repository.PredictionRepository

class PredictionViewModel (private val repository: PredictionRepository): ViewModel() {
    fun createPrediction(userId: String) = repository.getPrediction(userId)
}