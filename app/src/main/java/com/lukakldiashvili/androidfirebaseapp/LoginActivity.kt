package com.lukakldiashvili.androidfirebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    private lateinit var signUpButton: Button
    private lateinit var forgotPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        listeners()
    }


    private fun init () {
        signUpButton = findViewById(R.id.signUp_button)
        forgotPasswordButton = findViewById(R.id.forgot_button)
    }

    private fun listeners () {
        signUpButton.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        forgotPasswordButton.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
            finish()
        }
    }

}