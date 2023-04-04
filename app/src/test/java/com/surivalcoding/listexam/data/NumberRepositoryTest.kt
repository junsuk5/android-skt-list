package com.surivalcoding.listexam.data

import org.junit.Assert.*
import org.junit.Test

class NumberRepositoryTest {
    private val repository = NumberRepository()

    @Test
    fun update() {
        repository.update(
            Number(
                value = 1,
                isSelected = true,
            )
        )

        assertEquals(true, repository.findAll().first().isSelected)

        repository.update(
            Number(
                value = 1,
                isSelected = false,
            )
        )

        assertEquals(false, repository.findAll().first().isSelected)
    }

    @Test
    fun delete() {
        repository.delete(Number(
            value = 1,
            isSelected = true,
        ))

        assertEquals(99, repository.findAll().size)

        repository.delete(Number(
            value = 2,
            isSelected = true,
        ))

        assertEquals(98, repository.findAll().size)
    }

    @Test
    fun `데이터를 잘 가져와야 한다`() {
        assertEquals(100, repository.findAll().size)
    }
}