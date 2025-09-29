package com.mahshad.repository.offlinerepository

import com.google.common.truth.Truth.assertThat
import com.mahshad.database.Dao
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
    private lateinit var fakeDao: Dao
    private lateinit var defaultBasketRepository: DefaultBasketRepository

    @Before
    fun setup() {

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
