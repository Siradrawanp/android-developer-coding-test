package com.example.androiddevcodingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: Adapter
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var noInterText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        noInterText = findViewById(R.id.disconnected)
        recyclerAdapter = Adapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        fetchData()
        refreshData()

    }

    private fun refreshData() {
        swipeRefreshLayout = findViewById(R.id.swipe_layout)
        swipeRefreshLayout.setOnRefreshListener {
            fetchData()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun fetchData() {
        val retrofitAPI = RetrofitAPI.create().getRecipe()

        retrofitAPI.enqueue( object : Callback<List<Recipe>>{
            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>?) {
                if (response?.body() != null)
                    recyclerAdapter.setRecipeListItems(response.body()!!)
                noInterText.isVisible = false
            }

            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                noInterText.isVisible = true
                Toast.makeText(this@MainActivity, "Cannot connect to server\nCheck your internet connection", Toast.LENGTH_SHORT).show()
            }
        })
    }
}