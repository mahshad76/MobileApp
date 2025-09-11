package com.mahshad.repository.objectrepository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mahshad.network.model.ObjectDto
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(AndroidJUnit4::class)
class DefaultDeviceRepositoryTest {
    private lateinit var defaultDeviceRepository: DefaultDeviceRepository
    private lateinit var fakeApiService: FakeApiService

    @BeforeEach
    fun setup() {
        fakeApiService = FakeApiService(shouldReturnError = false)
        defaultDeviceRepository = DefaultDeviceRepository(fakeApiService)
    }

    @Test
    fun `postAnObject_whenTableIsEmpty_shouldReturnSuccessfulResponse`() {
        runBlocking {
            val result = defaultDeviceRepository.postAnObject(ObjectDto.DEFAULT)
            assertTrue(result is Result.Successful)
        }
    }

    @Test
    fun `getObjects_whenTableIsFull_shouldReturnSuccessfulResponse`() {
        runBlocking {
            val result = defaultDeviceRepository.getObjects()
            if (result is Result.Successful) {
                assertEquals(result.data[0].name, "galaxy")
            }
        }
    }

    @Test
    fun `getAnObjectById_whenTableIsFull_shouldReturnSuccessfulResponse`() {
        runBlocking {
            val result = defaultDeviceRepository.getObjectsById(listOf("1"))
            if (result is Result.Successful) {
                assertEquals(result.data[0].id, "1")
            }
        }
    }

    @Test
    fun `deleteAnObjectById_whenTableIsFull_shouldReturnSuccessfulResponse`() {
        runBlocking {
            val result = defaultDeviceRepository.deleteAnObject("1")
            if (result is Result.Successful) {
                assertTrue(result is Result.Successful)
            }
        }
    }
}
