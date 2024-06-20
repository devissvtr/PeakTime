package com.devissvtr.peaktime.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.devissvtr.peaktime.network.response.PredictionResponse
import com.devissvtr.peaktime.network.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import com.devissvtr.peaktime.repository.Result

class PredictionRepository(private val apiService: ApiService) {
    fun getPrediction(userId: String): LiveData<Result<PredictionResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val response = apiService.resultPrediction(userId)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}