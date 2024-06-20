package com.devissvtr.peaktime.ui.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivitySignupBinding
import com.devissvtr.peaktime.helper.UserModelFactory
import com.devissvtr.peaktime.ui.authentication.AuthActivity
import com.devissvtr.peaktime.ui.login.LoginActivity
import com.devissvtr.peaktime.utils.Result

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val register by viewModels<RegisterViewModel> {
        UserModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            postSingUp()
        }

        spannableText()
    }

    private fun postSingUp() {
        val name = binding.nameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        register.userRegister(name = name, email = email, password = password)
            .observe(this) { result ->
                if (result != null) {
                    when (result) {
                        is Result.InProgress -> {
                        }

                        is Result.Success -> {
                            val userId = result.data.data?.userId
                            Log.e("user id", "user id : $userId")
                            if (userId != null) {
                                AlertDialog.Builder(this).apply {
                                    setTitle("Registration Success")
                                    setMessage("Your account has been registered")
                                    setPositiveButton("Continue") { _, _ ->
                                        val intent = Intent(this@SignupActivity, AuthActivity::class.java)
                                        intent.putExtra("USER_ID", userId)
                                        startActivity(intent)
                                        finish()
                                    }
                                    create()
                                    show()
                                }
                            }else {
                                showToast("User id not found")
                            }
                        }
                        is Result.Failure -> {
                            showToast(result.message)
                            Log.e("SignupActivity", "Registration failed: ${result.message}")
                        }
                    }
                }
            }
    }


    private fun showToast(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    private fun spannableText() {
        val text = SpannableString(getString(R.string.already_register))

        val clickText = object : ClickableSpan(){
            override fun onClick(widget: View) {
                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        text.setSpan(clickText, 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setSpan(ForegroundColorSpan(Color.BLUE), 25, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.textView2.text = text
        binding.textView2.movementMethod = LinkMovementMethod.getInstance()
    }
}