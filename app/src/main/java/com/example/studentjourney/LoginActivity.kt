package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvReg = findViewById<TextView>(R.id.tvCA)
        tvReg.setOnClickListener {
            val intent = Intent(this, ::class.java)
            startActivity(intent)
        }
    }
}