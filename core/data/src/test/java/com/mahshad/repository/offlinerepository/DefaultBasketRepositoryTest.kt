package com.mahshad.repository.offlinerepository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.mahshad.database.Dao
import com.mahshad.model.data.Object
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DefaultBasketRepositoryTest() {
    private lateinit var fakeDao: Dao
    private lateinit var defaultBasketRepository: BasketRepository

    @BeforeEach // <--- CHANGE THIS
    fun setup() {
        fakeDao = FakeDao()
        defaultBasketRepository = DefaultBasketRepository(fakeDao)
    }

    @Test
    fun `insert a new object into the database`() = runTest {
        defaultBasketRepository.insert(Object.DEFAULT)
        val allObjects = defaultBasketRepository.selectAll().first()
        assertThat(allObjects).hasSize(2)
        assertThat(allObjects[0].id).isEqualTo("1")
        assertThat(allObjects[0].name).isEqualTo("galaxy")
    }
}
