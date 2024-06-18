package com.devissvtr.peaktime.network.preference

import android.media.session.MediaSession.Token
import com.devissvtr.peaktime.ui.customviews.CustomEmail

data class User(
    val email:String,
    val token: String,
    val isLogin: Boolean,
)