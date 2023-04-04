package com.surivalcoding.listexam.ui

import androidx.lifecycle.ViewModel
import com.surivalcoding.listexam.data.Number
import com.surivalcoding.listexam.data.NumberRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// state 패턴
// View에 보여주는 용도

// data 준비
// 클릭된 아이템들
data class MainUiState(
    val items: List<Number> = emptyList(),
)

class MainViewModel : ViewModel() {
    private val repository = NumberRepository()

    private var _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    init {
        // 초기값 설정
        _state.update {
            it.copy(
                items = repository.findAll()
            )
        }
    }

    fun clickItem(item: Number) {
        repository.update(item)

        _state.update {
            it.copy(
                items = repository.findAll()
            )
        }
    }

    fun removeItem(item: Number) {
        repository.delete(item)

        _state.update {
            it.copy(
                items = repository.findAll()
            )
        }
    }
}
