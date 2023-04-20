package com.lukakldiashvili.androidfirebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {

    private lateinit var signOutButton: Button
    private lateinit var usernameText: TextView

    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
        listeners()
    }

    private fun init () {
        signOutButton = findViewById(R.id.signOut_button)
        usernameText = findViewById(R.id.name_textView)

        usernameText.text = auth.currentUser?.displayName.toString()
    }

    private fun listeners () {
        signOutButton.setOnClickListener {
            auth.signOut()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}