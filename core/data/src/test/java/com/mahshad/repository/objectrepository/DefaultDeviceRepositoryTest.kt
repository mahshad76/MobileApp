package com.mahshad.repository.objectrepository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DefaultDeviceRepositoryTest {
    private lateinit var defaultDeviceRepository: DefaultDeviceRepository
    private lateinit var fakeApiService: FakeApiService

    @BeforeEach
    fun setup() {
        fakeApiService = FakeApiService()
        defaultDeviceRepository = DefaultDeviceRepository(fakeApiService)
    }

    @Test
    fun `getObjects returns successful result on API success`() {
        runTest {
            val result = defaultDeviceRepository.getObjects()
            assertThat(result).isInstanceOf(Result.Successful::class.java)
            val successfulResult = result as Result.Successful
            assertThat(successfulResult.data).hasSize(1)
            assertThat(successfulResult.data[0].id).isEqualTo("1")
        }
    }

    @Test
    fun `getObjects returns error result on API failure`() = runTest {
        fakeApiService.shouldReturnError = true
        val result = defaultDeviceRepository.getObjects()
        assertThat(result).isInstanceOf(Result.Error::class.java)
    }

    @Test
    fun `getObjectsById filters data correctly`() = runTest {
        fakeApiService.shouldReturnError = false
        val idsToFetch = listOf("1")
        val result = defaultDeviceRepository.getObjectsById(idsToFetch)
        assertThat(result).isInstanceOf(Result.Successful::class.java)
        val successfulResult = result as Result.Successful
        assertThat(successfulResult.data).hasSize(1)
        assertThat(successfulResult.data.map { it.id }).containsExactly("1")
    }
}
