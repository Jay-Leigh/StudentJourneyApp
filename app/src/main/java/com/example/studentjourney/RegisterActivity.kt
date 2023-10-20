package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.studentjourney.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    // declaring binding and firebase authentication variables
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // setting up the binding layout inflater
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting firebase authentication instance
        firebaseAuth = FirebaseAuth.getInstance()

        // intent to send user to login page
        binding.tvHaveAc.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // button that runs the registration
        binding.btnReg.setOnClickListener {
            val fname = binding.etFname.text.toString()
            val sname = binding.etSname.text.toString()
            val email = binding.etEmail.text.toString()
            val pass = binding.etPassw.text.toString()

            // checking if fields are empty
            if(fname.isNotEmpty() && sname.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }
        }

        // back button function
        val ibBack = findViewById<ImageButton>(R.id.ibBack)
        ibBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}