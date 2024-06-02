package com.devissvtr.peaktime.ui.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityLoginBinding
import com.devissvtr.peaktime.ui.signup.SignupActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spannableText()
    }

    private fun spannableText() {
        val text = SpannableString(getString(R.string.not_register))

        val clickText = object : ClickableSpan(){
            override fun onClick(widget: View) {
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
            }
        }
        text.setSpan(clickText, 14, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setSpan(ForegroundColorSpan(Color.BLUE), 14, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.textView.text = text
        binding.textView.movementMethod = LinkMovementMethod.getInstance()
    }
}