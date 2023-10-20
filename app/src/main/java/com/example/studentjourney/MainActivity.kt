package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.studentjourney.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    // declaring binding and firebase authentication variables
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SplashScreen
        Thread.sleep(4000)
        installSplashScreen()

        // getting firebase authentication instance
        auth = FirebaseAuth.getInstance()

        // Declaring variables
        val btnLogin = findViewById<Button>(R.id.Btnlogin)
        val btnReg = findViewById<Button>(R.id.BtnReg)

        // Creating Intent Functions
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Creating Intent Functions
        btnReg.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
    // checks if the user has already signed into the app and sends them to the home page if they have already signed in
    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}