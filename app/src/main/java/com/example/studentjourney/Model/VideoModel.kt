package com.example.studentjourney.Model

class VideoModel {
    var name: String = ""
    var thumbnail: String = ""
    var mediaurl: String = ""

    constructor(name:String?, thumbnail:String?, mediaurl:String?)
    {
        this.name = name!!
        this.thumbnail = thumbnail!!
        this.mediaurl = mediaurl!!
    }

    constructor(){}
}