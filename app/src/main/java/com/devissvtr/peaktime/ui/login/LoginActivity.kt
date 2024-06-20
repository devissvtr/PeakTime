package com.devissvtr.peaktime.ui.login

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
import com.devissvtr.peaktime.MainActivity
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityLoginBinding
import com.devissvtr.peaktime.helper.UserModelFactory
import com.devissvtr.peaktime.ui.form.FormActivity
import com.devissvtr.peaktime.ui.signup.SignupActivity
import com.devissvtr.peaktime.utils.Result


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val login by viewModels<LoginViewModel> {
        UserModelFactory.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spannableText()

        binding.button.setOnClickListener {
            postLogin()
        }
    }

    private fun postLogin() {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        login.login(email = email, password = password).observe(this) { result ->
            if (result != null) {
                when (result) {
                    is Result.InProgress -> {
                    }

                    is Result.Success -> {
                        AlertDialog.Builder(this).apply {
                            setTitle(getString(R.string.login_success))
                            setMessage(getString(R.string.login_successful))
                            setPositiveButton("Continue") { _, _ ->
                                val intent = Intent(this@LoginActivity, FormActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                startActivity(intent)
                                finish()
                            }
                            create()
                            show()
                        }
                    }

                    is Result.Failure -> {
                        showToast(result.message)
                        Log.e("LoginActivity", "Login failed: ${result.message}")
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun spannableText() {
        val text = SpannableString(getString(R.string.not_register))

        val clickText = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
            }
        }
        text.setSpan(clickText, 14, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setSpan(ForegroundColorSpan(Color.BLUE), 14, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.textView2.text = text
        binding.textView2.movementMethod = LinkMovementMethod.getInstance()
    }
}

//    @Composable
//    fun GoogleSignInButton(){
//        val context = LocalContext.current
//        val coroutineScope = rememberCoroutineScope()
//
//
//        val onClick: () -> Unit = {
//            val credentialManager = CredentialManager.create(context)
//
//            val rawNonce = UUID.randomUUID().toString()
//            val bytes = rawNonce.toByteArray()
//            val md = MessageDigest.getInstance("SHA-256")
//            val digest = md.digest(bytes)
//            val hasheadNonce = digest.fold(""){str, it -> str + "%02x".format(it)}
//
//            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
//                .setFilterByAuthorizedAccounts(false)
//                .setServerClientId("")
//                .setNonce("")
//                .build()
//
//            val request: GetCredentialRequest = GetCredentialRequest.Builder()
//                .addCredentialOption(googleIdOption)
//                .build()
//
//            coroutineScope.launch {
//                val result = credentialManager.getCredential(
//                    request = request,
//                    context = context,
//                )
//
//                val credential = result.credential
//
//                val googleIdTokenCredential = GoogleIdTokenCredential
//                    .createFrom(credential.data)
//
//                val googleIdToken = googleIdTokenCredential.idToken
//
//                Log.i(TAG, googleIdToken)
//
//                Toast.makeText(context, "you are signed in", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        //Button(onClick = onClick) {}
//    }
//}