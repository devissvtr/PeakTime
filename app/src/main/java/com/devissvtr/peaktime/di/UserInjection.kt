package com.devissvtr.peaktime.di

import android.content.Context
import com.devissvtr.peaktime.network.preference.UserPreferences
import com.devissvtr.peaktime.network.retrofit.ApiConfig
import com.devissvtr.peaktime.repository.UserRepository
import com.devissvtr.peaktime.ui.mode.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object UserInjection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreferences.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return UserRepository.getInstance(pref,apiService )
    }
}