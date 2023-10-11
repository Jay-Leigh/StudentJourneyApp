package com.example.studentjourney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bttmNav = findViewById<BottomNavigationView>(R.id.Nav)
        val navController = findNavController(R.id.llMain)

        /*val appBarConfiguration = AppBarConfiguration(setOf(R.id.))*/

        /*setupActionBarWithNavController(navController,appBarConfiguration)*/

        bttmNav.setupWithNavController(navController)
    }
}