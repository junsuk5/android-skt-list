package com.surivalcoding.listexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // data 준비
        val items = (1..100).toList()

        // 어댑터(data - view 연결) 준비
        val adapter = NumberAdapter(
            items.map { it.toString() }
        ) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        // View 준비
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // View에 Adapter 연결
        recyclerView.adapter = adapter
    }
}