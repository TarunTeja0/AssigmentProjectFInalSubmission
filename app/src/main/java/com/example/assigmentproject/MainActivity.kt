package com.example.assigmentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var recyclerViewAdapter:  RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("hello","hello")
        initRecyclerView()
        initViewModel()
        onItemClick()

    }

    private fun onItemClick() {

    }

    private fun initRecyclerView() {
        recyclerview = findViewById(R.id.recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerview.adapter = recyclerViewAdapter

        recyclerViewAdapter.onItemClick={
            val intent = Intent(this, DetailsActivity::class.java)
//            intent.putExtra("AnItem",it)
            intent.putExtra("product", it)
            startActivity(intent)
        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, {
            if(it != null){
                recyclerViewAdapter.setListData(it)
                recyclerViewAdapter.notifyDataSetChanged()
                Log.d("viewmodel","products != null")
                Toast.makeText(this, "Data Got", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this, "error in getting data", Toast.LENGTH_SHORT).show()
            }

        })
        viewModel.loadListOfData()
    }
}