package com.example.studentjourney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.studentjourney.Interface.IVideoLoadListener
import com.example.studentjourney.Model.VideoModel
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import edmt.dev.videoplayer.VideoPlayerRecyclerView
import edmt.dev.videoplayer.adapter.VideoPlayerRecyclerAdapter
import edmt.dev.videoplayer.model.MediaObject
import edmt.dev.videoplayer.utils.VerticalSpacingItemDecorator

class PrepActivity : AppCompatActivity(), IVideoLoadListener {

    private lateinit var listener: IVideoLoadListener
    private lateinit var VPRV : VideoPlayerRecyclerView
    private lateinit var fbShim : ShimmerFrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prep)

        VPRV = findViewById(R.id.VPRV)
        fbShim = findViewById(R.id.fbShim)

        init()

        val ibBack = findViewById<ImageButton>(R.id.ibBack)
        ibBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        listener = this

        val layoutManager = LinearLayoutManager(this)
        VPRV.layoutManager = layoutManager
        val verticalSpacingItemDecorator = VerticalSpacingItemDecorator(10)
        VPRV.addItemDecoration(verticalSpacingItemDecorator)
        loadVideoFromFirebase()
    }
    private fun loadVideoFromFirebase() {

        fbShim.startShimmerAnimation()

        val videoList = ArrayList<MediaObject>()

        val r = Runnable {
            FirebaseDatabase.getInstance()
                .getReference("Video")
                .addListenerForSingleValueEvent(object: ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists())
                        {
                            for (videoSnapshot in snapshot.children)
                            {
                                val videoModel = videoSnapshot.getValue(VideoModel::class.java)
                                val mediaObject = MediaObject(
                                    videoModel!!.name,
                                    videoModel!!.thumbnail,
                                    videoModel!!.mediaurl,
                                    ""
                                )
                                videoList.add(mediaObject)
                            }
                            listener.onVideoLoadSuccess(videoList)
                        }else
                        {
                            listener.onVideoFailed("Video Not Found")
                        }

                    }

                    override fun onCancelled(error: DatabaseError) {
                        listener.onVideoFailed(error.message)
                    }

                })
        }
        Handler(Looper.getMainLooper()).postDelayed(r,3000)
    }


    override fun onVideoLoadSuccess(videoModelList: ArrayList<MediaObject>) {
        VPRV.setMediaObjects(videoModelList)
        val adapter = VideoPlayerRecyclerAdapter(videoModelList, initGlide())
        VPRV.adapter = adapter

        fbShim.stopShimmerAnimation()
        fbShim.visibility = View.GONE
    }

    private fun initGlide(): RequestManager {
        val options = RequestOptions()
            .placeholder(edmt.dev.videoplayer.R.drawable.white_background)
            .error(edmt.dev.videoplayer.R.drawable.white_background)
        return Glide.with(this).setDefaultRequestOptions(options)
    }

    override fun onVideoFailed(message: String) {
        fbShim.stopShimmerAnimation()
        fbShim.visibility = View.GONE
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}