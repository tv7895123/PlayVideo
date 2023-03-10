package com.example.playvideo

import com.example.playvideo.datalayer.PlayList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


interface IabNetworkApi
{
    //=====================================================================================
    // Get IAB product ID and Price by pid
    //=====================================================================================
    @GET("test1.0/backstage/exm1")
    suspend fun getPlayList(
        @Header("Authorization") authToken:String): Response<PlayList>
}