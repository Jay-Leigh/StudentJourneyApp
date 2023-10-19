package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.studentjourney.adapters.ViewPagerAdapter
import com.example.studentjourney.fragments.Ailum1Fragment
import com.example.studentjourney.fragments.Ailum2Fragment
import com.example.studentjourney.fragments.Ailum3Fragment
import com.google.android.material.tabs.TabLayout
import java.time.LocalDate
import java.time.Month

class AlumniActivity : AppCompatActivity() {

    private lateinit var pager : ViewPager
    private lateinit var tab : TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumni)

        pager = findViewById(R.id.Vpager)
        tab = findViewById(R.id.tabs)

        //running tabs function
        setUpTabs()

        //setting date for next graduation
        val date = LocalDate.of(2023,Month.DECEMBER, 5)

        val tvDate = findViewById<TextView>(R.id.tvDate)

        tvDate.text = date.toString()

        val ibBack = findViewById<ImageButton>(R.id.ibBack)
        ibBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Ailum1Fragment(), "Alumni 1")
        adapter.addFragment(Ailum2Fragment(), "Alumni 2")
        adapter.addFragment(Ailum3Fragment(), "Alumni 3")
        pager.adapter = adapter
        tab.setupWithViewPager(pager)

        tab.getTabAt(0)!!.setIcon(R.drawable.alumni1)
        tab.getTabAt(1)!!.setIcon(R.drawable.alumni1)
        tab.getTabAt(2)!!.setIcon(R.drawable.alumni1)
    }
}