package com.example.androiddevcodingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerAdapter = Adapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val retrofitAPI = RetrofitAPI.create().getRecipe()

        retrofitAPI.enqueue( object : Callback<List<Recipe>>{
            override fun onResponse(call: Call<List<Recipe>>?, response: Response<List<Recipe>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setRecipeListItems(response.body()!!)
            }
            override fun onFailure(call: Call<List<Recipe>>?, t: Throwable?){

            }
        })

    }
}