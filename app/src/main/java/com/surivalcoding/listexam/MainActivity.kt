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
        // 클릭된 아이템들
        val clickedItems = mutableSetOf<String>()

        // View 준비
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 어댑터(data - view 연결) 준비
        val adapter = NumberAdapter(
            dataSet = items.map { it.toString() },
            clickedItems = clickedItems,
        ) {
            if (clickedItems.contains(it)) {
                clickedItems.remove(it)
            } else {
                clickedItems.add(it)
            }

            // UI 갱신
            recyclerView.adapter?.notifyDataSetChanged()

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        // View에 Adapter 연결
        recyclerView.adapter = adapter
    }
}