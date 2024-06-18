package com.devissvtr.peaktime.helper

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.devissvtr.peaktime.di.UserInjection
import com.devissvtr.peaktime.repository.UserRepository

class UserModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var INSTANCE: UserModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): UserModelFactory {
            if (INSTANCE == null) {
                synchronized(UserModelFactory::class.java) {
                    INSTANCE = UserModelFactory(UserInjection.provideRepository(context))
                }
            }
            return INSTANCE as UserModelFactory
        }
    }
}