package com.devissvtr.peaktime.network.preference

data class User(
    val isLogin: Boolean,
    val email:String,
    val token: String,
)