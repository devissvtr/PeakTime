package com.devissvtr.peaktime.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devissvtr.peaktime.network.preference.User
import com.devissvtr.peaktime.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository ) : ViewModel() {
    fun login(email: String, password: String) = repository.login(email, password)

    fun saveSession(user: User) {
        viewModelScope.launch {
        }
    }
}