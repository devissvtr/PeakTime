package com.devissvtr.peaktime.utils

import androidx.core.app.NotificationCompat.MessagingStyle.Message


sealed class Result<out T> private constructor(){
    data class Success<out U> (val data: U): Result<U>()
    data class Failure(val message: String): Result<Nothing>()
    data object InProgress : Result<Nothing>()

}