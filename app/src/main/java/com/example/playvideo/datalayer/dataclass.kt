package com.example.playvideo.datalayer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PlayList(val video:Video)


data class Video(val source:Source)


data class Source
(
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("source")
    @Expose
    var source: List<SourceData>
)

data class SourceData(
    val url:String
)