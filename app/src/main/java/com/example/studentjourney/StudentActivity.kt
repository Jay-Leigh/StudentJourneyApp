package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.view.MotionEvent;
import android.widget.Button

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        // back button function
        val ibBack = findViewById<ImageButton>(R.id.ibBack)
        ibBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Question 1
        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {

            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.pop_up_q1, null)

            val wid = LinearLayout.LayoutParams.WRAP_CONTENT
            val high = LinearLayout.LayoutParams.WRAP_CONTENT
            val focus= true
            val popupWindow = PopupWindow(popupView, wid, high, focus)

            popupWindow.showAtLocation(button, Gravity.CENTER, 0, 0)

        }

        // Question 2
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {

            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.pop_up_q2, null)

            val wid = LinearLayout.LayoutParams.WRAP_CONTENT
            val high = LinearLayout.LayoutParams.WRAP_CONTENT
            val focus= true
            val popupWindow = PopupWindow(popupView, wid, high, focus)

            popupWindow.showAtLocation(button2, Gravity.CENTER, 0, 0)

        }

        // Question 3
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {

            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.pop_up_q3, null)

            val wid = LinearLayout.LayoutParams.WRAP_CONTENT
            val high = LinearLayout.LayoutParams.WRAP_CONTENT
            val focus= true
            val popupWindow = PopupWindow(popupView, wid, high, focus)

            popupWindow.showAtLocation(button3, Gravity.CENTER, 0, 0)

        }

        // Question 4
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {

            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.pop_up_q4, null)

            val wid = LinearLayout.LayoutParams.WRAP_CONTENT
            val high = LinearLayout.LayoutParams.WRAP_CONTENT
            val focus= true
            val popupWindow = PopupWindow(popupView, wid, high, focus)

            popupWindow.showAtLocation(button4, Gravity.CENTER, 0, 0)

        }

        // Question 5
        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {

            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.pop_up_q5, null)

            val wid = LinearLayout.LayoutParams.WRAP_CONTENT
            val high = LinearLayout.LayoutParams.WRAP_CONTENT
            val focus= true
            val popupWindow = PopupWindow(popupView, wid, high, focus)

            popupWindow.showAtLocation(button5, Gravity.CENTER, 0, 0)

        }

        // Question 6
        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {

            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.pop_up_q6, null)

            val wid = LinearLayout.LayoutParams.WRAP_CONTENT
            val high = LinearLayout.LayoutParams.WRAP_CONTENT
            val focus= true
            val popupWindow = PopupWindow(popupView, wid, high, focus)

            popupWindow.showAtLocation(button6, Gravity.CENTER, 0, 0)

        }
    }
}