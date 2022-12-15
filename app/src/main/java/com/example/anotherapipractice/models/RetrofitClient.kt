package com.example.anotherapipractice.models

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    /*private val client = OkHttpClient.Builder().build()

    fun getRetrofit():Retrofit{
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL) // change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()
    }

}

var gson = GsonBuilder()
    .setLenient()
    .create()

     */
    val myApi: ApiInterface

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://lms.byteedgebiz.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        myApi = retrofit.create(ApiInterface::class.java)
    }

    companion object {

        @get:Synchronized
        var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }


}