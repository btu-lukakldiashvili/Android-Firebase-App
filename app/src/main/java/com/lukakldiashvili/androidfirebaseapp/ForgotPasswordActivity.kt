package com.lukakldiashvili.androidfirebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var resetButton: Button

    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        init()
        listeners()
    }

    private fun init () {
        resetButton = findViewById(R.id.reset_button)
        emailEditText = findViewById(R.id.email_EditText)
    }

    private fun listeners () {
        resetButton.setOnClickListener{
            val email = emailEditText.text.toString()

            if (email.isEmpty() || email.contains(" ")) {
                return@setOnClickListener
            }

            auth.sendPasswordResetEmail(email)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}