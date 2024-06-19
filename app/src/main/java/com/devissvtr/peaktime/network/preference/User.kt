package com.devissvtr.peaktime.network.preference

import android.media.session.MediaSession.Token
import com.devissvtr.peaktime.ui.customviews.CustomEmail

data class User(
    val isLogin: Boolean,
    val email:String,
    val token: String,
)