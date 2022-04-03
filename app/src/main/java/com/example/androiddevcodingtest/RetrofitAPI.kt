package com.example.androiddevcodingtest

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("android-test/recipes.json")
    fun getRecipe(): Call<List<Recipe>>

    companion object {
        var BASE_URL = "https://hf-android-app.s3-eu-west-1.amazonaws.com/"
        fun create():RetrofitAPI {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitAPI::class.java)
        }
    }

}