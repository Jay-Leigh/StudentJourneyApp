package com.example.studentjourney.Interface

import edmt.dev.videoplayer.model.MediaObject

interface IVideoLoadListener {
    fun onVideoLoadSuccess(videoModelList: ArrayList<MediaObject>)
    fun onVideoFailed(message:String)
}