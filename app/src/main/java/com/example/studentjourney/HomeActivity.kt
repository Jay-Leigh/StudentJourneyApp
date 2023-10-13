package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        val displayName = intent.getStringArrayExtra("name")

        findViewById<TextView>(R.id.tvDname).text = displayName.toString()

        val bttmNav = findViewById<BottomNavigationView>(R.id.Nav)
        val navController = findNavController(R.id.llMain)

        /*val appBarConfiguration = AppBarConfiguration(setOf(R.id.))*/

        /*setupActionBarWithNavController(navController,appBarConfiguration)*/

        bttmNav.setupWithNavController(navController)

        clickListener();
    }
    private fun clickListener(){
        val imgPrep = findViewById<ImageView>(R.id.ivPrep);
        val imgTeach = findViewById<ImageView>(R.id.ivTeach);
        val imgAssess = findViewById<ImageView>(R.id.ivAssess);
        val imgCert = findViewById<ImageView>(R.id.ivCert);
        val imgAlumni = findViewById<ImageView>(R.id.ivAlumni);
        val imgSupp = findViewById<ImageView>(R.id.ivSupp);

        imgPrep.setOnClickListener{
            openPrep()
        }
        imgTeach.setOnClickListener{
            openTeach()
        }
        imgAssess.setOnClickListener{
            openAssess()
        }
        imgCert.setOnClickListener{
            openCert()
        }
        imgAlumni.setOnClickListener{
            openAlumni()
        }
        imgSupp.setOnClickListener{
            openSupp()
        }
    }
    private fun openPrep(){
        startActivity(Intent(this@HomeActivity, PrepActivity::class.java))
    }
    private fun openTeach(){
        startActivity(Intent(this@HomeActivity, TeachActivity::class.java))
    }
    private fun openAssess(){
        startActivity(Intent(this@HomeActivity, AssessActivity::class.java))
    }
    private fun openCert(){
        startActivity(Intent(this@HomeActivity, CertActivity::class.java))
    }
    private fun openAlumni(){
        startActivity(Intent(this@HomeActivity, AlumniActivity::class.java))
    }
    private fun openSupp(){
        startActivity(Intent(this@HomeActivity, StudentActivity::class.java))
    }
}