package com.example.anotherapipractice.models

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("login")
    fun getLogin(@Body loginRequest: LoginRequest): Call<LoginModel>

}