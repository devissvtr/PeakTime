package com.devissvtr.peaktime.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.devissvtr.peaktime.network.response.FormResponse
import com.devissvtr.peaktime.network.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class FormRepository private constructor(private val apiService: ApiService) {
    fun formData(
//        userId: String,
        age: Int,
        task: String,
        averageRest: Int,
        moodBeforeWork: String,
        deadline: String,
        importance: Int,
        sleepAverage: Int,
        urgency: Int,
        totalGangguan: Array<String>,
        averageWorkHour: Int,
        workDays: String
    ): LiveData<Result<FormResponse>> = liveData(Dispatchers.IO) {
        emit(Result.Loading)

        try {
            val response = apiService.formData(
//                userId,
                age.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
                task.toRequestBody("text/plain".toMediaTypeOrNull()),
                averageRest.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
                moodBeforeWork.toRequestBody("text/plain".toMediaTypeOrNull()),
                deadline.toRequestBody("text/plain".toMediaTypeOrNull()),
                importance.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
                sleepAverage.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
                urgency.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
                totalGangguan.joinToString(",").toRequestBody("text/plain".toMediaTypeOrNull()),
                averageWorkHour.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
                workDays.toRequestBody("text/plain".toMediaTypeOrNull())
            )
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }

//    fun getToken(): Flow<String?> = .getToken()
//
//    private suspend fun saveToken(token: String) {
//        authDataStore.saveToken(token)
//    }
//
//    suspend fun clearToken() {
//        authDataStore.clearToken()
//    }
//
//    private fun String.toRequestBody(mediaType: String): RequestBody {
//        return this.toRequestBody(mediaType.toMediaTypeOrNull())
//    }

    companion object {
        @Volatile
        private var instance: FormRepository? = null

        fun getInstance(apiService: ApiService): FormRepository =
            instance ?: synchronized(this) {
                instance ?: FormRepository(apiService).also { instance = it }
            }
    }
}


//    fun submitForm(userId: String, formRequest: FormRequest, callback: (FormResponse?) -> Unit) {

//        private val apiService: ApiService
//
//        val call = apiService.submitForm(userId, formRequest)
//        call.enqueue(object : Callback<FormResponse> {
//            override fun onResponse(call: Call<FormResponse>, response: Response<FormResponse>) {
//                if (response.isSuccessful) {
//                    callback(response.body())
//                } else {
//                    callback(null)
//                }
//            }
//
//            override fun onFailure(call: Call<FormResponse>, t: Throwable) {
//                callback(null)
//            }
//        })