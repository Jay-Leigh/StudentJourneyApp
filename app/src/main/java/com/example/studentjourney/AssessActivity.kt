package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import java.time.LocalDate
import java.time.Month

class AssessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assess)

        val ibBack = findViewById<ImageButton>(R.id.ibBack)
        ibBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //date 1
        val date1 = LocalDate.of(2023, Month.OCTOBER, 31)
        val vdate1 = findViewById<TextView>(R.id.Date1)
        vdate1.text = date1.toString()

        //date 2
        val date2 = LocalDate.of(2025, Month.JULY, 12)
        val vdate2 = findViewById<TextView>(R.id.Date2)
        vdate2.text = date2.toString()

        //date 3
        val date3 = LocalDate.of(2024, Month.FEBRUARY, 29)
        val vdate3 = findViewById<TextView>(R.id.Date3)
        vdate3.text = date3.toString()
    }
}