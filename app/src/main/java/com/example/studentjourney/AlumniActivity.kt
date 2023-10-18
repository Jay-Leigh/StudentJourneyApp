package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.studentjourney.adapters.ViewPagerAdapter
import com.example.studentjourney.fragments.Ailum1Fragment
import com.example.studentjourney.fragments.Ailum2Fragment
import com.example.studentjourney.fragments.Ailum3Fragment
import kotlinx.android.synthetic.main.activity_alumni.Vpager
import kotlinx.android.synthetic.main.activity_alumni.tabs
import java.time.LocalDate
import java.time.Month

class AlumniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumni)

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
        Vpager.adapter = adapter
        tabs.setupWithViewPager(Vpager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.alumni1)
        tabs.getTabAt(1)!!.setIcon(R.drawable.alumni1)
        tabs.getTabAt(2)!!.setIcon(R.drawable.alumni1)
    }
}