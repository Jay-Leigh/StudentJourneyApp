package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentjourney.adapters.RResultsAdapter
import com.example.studentjourney.classs.Results
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CertActivity : AppCompatActivity() {

    // declaring binding variables
    private lateinit var dbref : DatabaseReference
    private lateinit var resultsRecyclerview : RecyclerView
    private lateinit var resultsArrayList : ArrayList<Results>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cert)

        // back button function
        val ibBack = findViewById<ImageButton>(R.id.ibBack)
        ibBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // sets recycler view
        resultsRecyclerview = findViewById(R.id.rv)
        resultsRecyclerview.layoutManager = LinearLayoutManager(this)
        resultsRecyclerview.setHasFixedSize(true)

        resultsArrayList = arrayListOf<Results>()
        getResultData()
    }

        // function that fetches data from database and displays it onto the page inside the recycler view
        private fun getResultData() {

            dbref = FirebaseDatabase.getInstance().getReference("Results")

            dbref.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()){

                        for (resultSnapshot in snapshot.children){

                            val results = resultSnapshot.getValue(Results::class.java)
                            resultsArrayList.add(results!!)

                        }
                        resultsRecyclerview.adapter = RResultsAdapter(resultsArrayList)

                    }

                }
                override fun onCancelled(error: DatabaseError) {

                }
            })

        }
    }
