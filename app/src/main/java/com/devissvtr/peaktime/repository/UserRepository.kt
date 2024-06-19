package com.devissvtr.peaktime.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.liveData
import com.devissvtr.peaktime.network.preference.UserPreferences
import com.devissvtr.peaktime.network.response.LoginResponse
import com.devissvtr.peaktime.network.response.RegisterResponse
import com.devissvtr.peaktime.network.retrofit.ApiService
import com.devissvtr.peaktime.utils.Result
import com.google.gson.Gson
import retrofit2.HttpException

class UserRepository private constructor(
    private var apiService: ApiService,
    private val userPreference: UserPreferences
) {

    fun updateApiService(apiService: ApiService) {
        this.apiService = apiService
    }

    fun register(name: String, email: String, password: String) = liveData {
        emit(Result.InProgress)
        try {
            emit(Result.Success(apiService.register(name, email, password)))
        } catch (e: HttpException) {
            val errorResponse = e.response()?.errorBody()?.string()?.let {
                Gson().fromJson(it, RegisterResponse::class.java)
            }
            emit(Result.Failure(errorResponse?.message ?: "Unknown error"))
        }
    }

    fun login(email: String, password: String) = liveData {
        emit(Result.InProgress)
        try {
            emit(Result.Success(apiService.login(email, password)))
        } catch (e: HttpException) {
            val errorResponse = e.response()?.errorBody()?.string()?.let {
                Gson().fromJson(it, LoginResponse::class.java)
            }
            emit(Result.Failure(errorResponse?.message ?: "Unknown error"))
        }
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(userPreference: UserPreferences, apiService: ApiService): UserRepository {
            return instance ?: synchronized(this) {
                instance ?: UserRepository(apiService, userPreference).also { instance = it }
            }
        }
    }

}