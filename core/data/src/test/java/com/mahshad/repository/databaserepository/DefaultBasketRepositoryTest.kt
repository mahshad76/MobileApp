package com.mahshad.repository.databaserepository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.mahshad.database.DAO
import com.mahshad.database.Database
import org.junit.After
import org.junit.Before
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

    @After
    fun tearDown() {
        fakeDatabase.close()
    }

}
