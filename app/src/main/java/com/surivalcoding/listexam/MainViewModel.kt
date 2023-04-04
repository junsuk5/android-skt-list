package com.surivalcoding.listexam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surivalcoding.listexam.data.Number
import com.surivalcoding.listexam.data.NumberRepository

// state 패턴
// View에 보여주는 용도

// data 준비
// 클릭된 아이템들
data class MainUiState(
    val items: List<Number> = emptyList(),
)

class MainViewModel : ViewModel() {
    private val repository = NumberRepository()

    private var _state = MutableLiveData(MainUiState())
    val state: LiveData<MainUiState>
        get() = _state

    init {
        // 초기값 설정
        _state.value = state.value!!.copy(
            items = repository.findAll()
        )
    }

    fun clickItem(item: Number) {
        repository.update(item)

        _state.value = state.value!!.copy(
            items = repository.findAll()
        )
    }

    fun removeItem(item: Number) {
        repository.delete(item)

        _state.value = state.value!!.copy(
            items = repository.findAll()
        )
    }
}
