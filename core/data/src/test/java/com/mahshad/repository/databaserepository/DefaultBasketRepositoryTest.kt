package com.mahshad.repository.databaserepository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import com.mahshad.database.DAO
import com.mahshad.database.Database
import com.mahshad.model.data.Object
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DefaultBasketRepositoryTest() {
    private lateinit var fakeDatabase: Database
    private lateinit var fakeDao: DAO
    private lateinit var defaultBasketRepository: DefaultBasketRepository

    @Before
    fun setup() {
        fakeDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            Database::class.java
        ).allowMainThreadQueries().build()
        fakeDao = fakeDatabase.dao()
        defaultBasketRepository = DefaultBasketRepository(fakeDao)
    }

    @Test
    fun `insert a new object into the database`() = runTest {
        defaultBasketRepository.insert(Object.DEFAULT)
        val allObjects = fakeDao.getAll().first()
        assertThat(allObjects).hasSize(1)
        assertThat(allObjects[0].id).isEqualTo("1")
        assertThat(allObjects[0].name).isEqualTo("galaxy")
    }

    @After
    fun tearDown() {
        fakeDatabase.close()
    }
}
