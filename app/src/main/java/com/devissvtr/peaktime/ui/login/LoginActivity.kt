package com.devissvtr.peaktime.ui.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Message
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.devissvtr.peaktime.R
import com.devissvtr.peaktime.databinding.ActivityLoginBinding
import com.devissvtr.peaktime.ui.schedule.ScheduleActivity
import com.devissvtr.peaktime.ui.signup.SignupActivity
import com.google.android.libraries.identity.googleid.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import retrofit2.http.Tag
import java.security.MessageDigest
import java.util.UUID
import kotlin.math.log


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spannableText()
        binding.button.setOnClickListener {
            val intent = Intent(this@LoginActivity, ScheduleActivity::class.java)
            startActivity(intent)
        }

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

        binding.textView2.text = text
        binding.textView2.movementMethod = LinkMovementMethod.getInstance()
    }

    @Composable
    fun GoogleSignInButton(){
        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()


        val onClick: () -> Unit = {
            val credentialManager = CredentialManager.create(context)

            val rawNonce = UUID.randomUUID().toString()
            val bytes = rawNonce.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            val hasheadNonce = digest.fold(""){str, it -> str + "%02x".format(it)}

            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId("")
                .setNonce("")
                .build()

            val request: GetCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            coroutineScope.launch {
                val result = credentialManager.getCredential(
                    request = request,
                    context = context,
                )

                val credential = result.credential

                val googleIdTokenCredential = GoogleIdTokenCredential
                    .createFrom(credential.data)

                val googleIdToken = googleIdTokenCredential.idToken

                Log.i(TAG, googleIdToken)

                Toast.makeText(context, "you are signed in", Toast.LENGTH_SHORT).show()
            }
        }

        //Button(onClick = onClick) {}
    }
}