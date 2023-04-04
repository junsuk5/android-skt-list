package com.surivalcoding.listexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 준비
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 어댑터(data - view 연결) 준비

        val adapter = NumberAdapter(
            onClicked = {
                viewModel.clickItem(it)
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            },
            onLongClicked = {
                viewModel.removeItem(it)
            }
        )

        // View에 Adapter 연결
        recyclerView.adapter = adapter

        viewModel.state.asLiveData().observe(this) { state ->
            adapter.submitList(state.items)
        }
    }
}