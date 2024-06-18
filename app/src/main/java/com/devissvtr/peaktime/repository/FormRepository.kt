package com.devissvtr.peaktime.repository

import com.devissvtr.peaktime.network.response.FormRequest
import com.devissvtr.peaktime.network.response.FormResponse
import com.devissvtr.peaktime.network.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormRepository {
//    fun submitForm(userId: String, formRequest: FormRequest, callback: (FormResponse?) -> Unit) {
//
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
//    }
}