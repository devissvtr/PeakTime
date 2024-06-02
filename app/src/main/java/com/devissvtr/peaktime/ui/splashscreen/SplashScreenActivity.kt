package com.devissvtr.peaktime.ui.splashscreen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.window.SplashScreen
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivitySplashScreenBinding
import com.devissvtr.peaktime.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private val splashTime: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        }, splashTime)

        //fot tv_peaktime
        val spannableString = SpannableString("PeakTime")
        val peakColorSpan = ForegroundColorSpan(Color.parseColor("#219EBC"))
        spannableString.setSpan(peakColorSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.tvPeaktime.text = spannableString
    }
}