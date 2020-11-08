package com.example.intents_proj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et_username = findViewById(R.id.et_username) as EditText
        var et_password = findViewById(R.id.et_password) as EditText
        var btn_submit = findViewById(R.id.btn_submit) as Button

        btn_submit.setOnClickListener {
            val username = et_username;
            val password = et_password;

            // checking of credentials
           if (username.text.isNullOrEmpty() || password.text.isNullOrEmpty()) {
               Toast.makeText(this, "Username or Password is empty, please try again",Toast.LENGTH_LONG).show()
           } else if (username.text.toString().trim().equals("admin") && password.text.toString().trim().equals("admin")) {
               Toast.makeText(this, "Login successful!",Toast.LENGTH_LONG).show()
               val intent = Intent(this, HomeButtons::class.java)
               startActivity(intent)
           } else {
               Toast.makeText(this, "Wrong Credentials, please try again",Toast.LENGTH_LONG).show()
           }
        }
    }

}