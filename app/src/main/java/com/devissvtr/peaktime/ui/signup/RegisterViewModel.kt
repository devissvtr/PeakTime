package com.devissvtr.peaktime.ui.signup

import androidx.lifecycle.ViewModel
import com.devissvtr.peaktime.repository.UserRepository

class RegisterViewModel(private val repository: UserRepository): ViewModel() {
    fun userRegister(name: String, email: String, password: String) =
        repository.register(name, email, password)
}