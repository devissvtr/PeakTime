package com.devissvtr.peaktime.helper

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devissvtr.peaktime.di.UserInjection
import com.devissvtr.peaktime.repository.UserRepository
import com.devissvtr.peaktime.ui.authentication.AuthViewModel
import com.devissvtr.peaktime.ui.login.LoginViewModel
import com.devissvtr.peaktime.ui.signup.RegisterViewModel

class UserModelFactory(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
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

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }

            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }

            modelClass.isAssignableFrom(AuthViewModel::class.java) -> {
                AuthViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("\"Unknown ViewModel class: ${modelClass.name}\"")
        }
    }
}