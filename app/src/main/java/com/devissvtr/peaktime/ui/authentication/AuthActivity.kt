package com.devissvtr.peaktime.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.devissvtr.peaktime.databinding.ActivityAuthBinding
import com.devissvtr.peaktime.helper.UserModelFactory
import com.devissvtr.peaktime.ui.login.LoginActivity
import com.devissvtr.peaktime.utils.Result
import kotlin.math.log

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private val auth by viewModels<AuthViewModel> {
        UserModelFactory.getInstance(this)
    }
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userId = intent.getStringExtra("USER_ID")
        Log.d("userid", "userid is $userId")

        binding.button.setOnClickListener {
            val token = binding.tokenEditText.text.toString()
            if (token.isNotEmpty() && userId != null) {
                verifyToken(userId ?: "", token)
            } else {
                showToast("Please input the token")
            }
        }
    }

    private fun verifyToken(userId: String, token: String) {
        auth.authenticateUser(userId, token)
            .observe(this) { result ->
            when (result) {
                is Result.InProgress -> {
                }

                is Result.Success -> {
                    val intent = Intent(this@AuthActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                is Result.Failure -> {
                    showToast("Failed to verify token: ${result.message}")
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}