package com.example.tugasandroidstechoq

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    fun getPhotos(): Call<ArrayList<userModel>>
}
