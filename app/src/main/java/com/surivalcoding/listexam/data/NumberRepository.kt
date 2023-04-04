package com.surivalcoding.listexam.data

// 숫자 제공, 조작(값 업데이트), 삭제
class NumberRepository {
    private var numbers: List<Number> = (1..100).map { Number(value = it) }

    // CRUD
    fun insert(number: Number) {}
    fun update(number: Number) {
        numbers = numbers.map {
            if (it.value == number.value) {
                // 바꾸고
                it.copy(isSelected = !it.isSelected)
            } else {
                it
            }
        }
    }
    fun delete(number: Number) {
        numbers = numbers.filter { it.value != number.value }
    }
    fun findAll(): List<Number> {
        return numbers
    }
}