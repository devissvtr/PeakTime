package com.devissvtr.peaktime.ui.authentication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devissvtr.peaktime.network.response.AutenticationHandler
import com.devissvtr.peaktime.repository.UserRepository
import com.devissvtr.peaktime.utils.Result

class AuthViewModel(private val userRepository: UserRepository): ViewModel() {
    fun authenticateUser(userId: String, token: String): LiveData<Result<AutenticationHandler>> {
        return userRepository.verification(userId, token)
    }
}