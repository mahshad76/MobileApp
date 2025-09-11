package com.mahshad.repository.databaserepository

import FakeDAO
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mahshad.database.ObjectEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(AndroidJUnit4::class)
class DefaultBasketRepositoryTest() {

    lateinit var fakeDao: FakeDAO

    @BeforeEach
    fun setup() {
        fakeDao = FakeDAO()
        val fakeObjects = mutableListOf(
            ObjectEntity.DEFAULT
        )
        runBlocking {
            fakeDao.insertAll(fakeObjects)
        }
    }

    @Test
    fun `getAllObjects_whenTableIsNotEmpty_shouldReturnAllObjects`() {
        runBlocking {
            val objects = fakeDao.getAll().first()
            assertEquals(1, objects.size)
            assertEquals("galaxy", objects[0].name)
        }
    }
}
