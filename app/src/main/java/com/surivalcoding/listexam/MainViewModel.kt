package com.surivalcoding.listexam

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // data 준비
    val items = (1..100).toMutableList()
    // 클릭된 아이템들
    val clickedItems = mutableSetOf<String>()

    fun clickItem(item: String) {
        if (clickedItems.contains(item)) {
            clickedItems.remove(item)
        } else {
            clickedItems.add(item)
        }
    }
}