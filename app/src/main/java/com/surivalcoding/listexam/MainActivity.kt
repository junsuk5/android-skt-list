package com.surivalcoding.listexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
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


        viewModel.state.observe(this) { state ->
            val adapter = NumberAdapter(
                dataSet = state.items.map { it.toString() },
                clickedItems = state.clickedItems,
                onClicked = {
                    viewModel.clickItem(it)

//                    // UI 갱신
//                    recyclerView.adapter?.notifyDataSetChanged()

                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                },
                onLongClicked = {
                    println()
                    viewModel.removeItem(it)
                }
            )

            // View에 Adapter 연결
            recyclerView.adapter = adapter
        }
    }
}