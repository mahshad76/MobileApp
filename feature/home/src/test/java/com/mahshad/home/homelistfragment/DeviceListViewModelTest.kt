package com.mahshad.home.homelistfragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mahshad.common.getOrAwaitValues
import com.mahshad.model.data.Object
import com.mahshad.repository.databaserepository.BasketRepository
import com.mahshad.repository.objectrepository.DeviceRepository
import com.mahshad.repository.objectrepository.Result
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import kotlin.test.assertTrue

class DeviceListViewModelTest {
    @Mock
    private lateinit var fakeDeviceRepository: DeviceRepository

    @Mock
    private lateinit var fakeBasketRepository: BasketRepository
    private lateinit var deviceListViewModel: DevicesListViewModel
    private lateinit var observer: Observer<Result<List<Object>>?>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        deviceListViewModel = DevicesListViewModel(fakeDeviceRepository, fakeBasketRepository)
        observer = Observer { }
    }

    @Test
    fun `updateObjectsList - when repository returns data - uiState is Loading and Successful`() =
        runTest {
            val mockedData = Result.Successful(
                listOf(Object.DEFAULT)
            )
            whenever(fakeDeviceRepository.getObjects())
                .thenReturn(mockedData)
            deviceListViewModel.updateObjectsList()
            val list = deviceListViewModel.objectState.getOrAwaitValues(
                2
            )
            assertTrue(
                list[0] is Result.Loading &&
                        list[1] is Result.Successful<List<Object>>
            )
        }

    @After
    fun teardown() {
        deviceListViewModel.objectState.removeObserver(observer)
    }

}
