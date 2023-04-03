package com.surivalcoding.listexam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// state 패턴
// View에 보여주는 용도

// data 준비
// 클릭된 아이템들
data class MainUiState(
    val items: List<Int> = emptyList(),
    val clickedItems: Set<Int> = emptySet(),
)

class MainViewModel : ViewModel() {
    private var _state = MutableLiveData(
        MainUiState(
            items = (1..100).toList()
        )
    )
    val state: LiveData<MainUiState>
        get() = _state


    fun clickItem(item: Int) {
        val newClickedItems = state.value!!.clickedItems.toMutableSet()
        if (state.value!!.clickedItems.contains(item)) {
            newClickedItems.remove(item)

            _state.value = state.value!!.copy(
                clickedItems = newClickedItems
            )
        } else {
            newClickedItems.add(item)

            _state.value = state.value!!.copy(
                clickedItems = newClickedItems
            )
        }
    }

    fun removeItem(item: Int) {
        val newItems = state.value!!.items.toMutableList()
        newItems.remove(item)

        _state.value = state.value!!.copy(
            items = newItems
        )
    }
}
