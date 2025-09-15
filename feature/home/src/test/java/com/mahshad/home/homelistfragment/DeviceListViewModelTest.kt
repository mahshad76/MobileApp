package com.mahshad.home.homelistfragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
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
            deviceListViewModel.objectState
        }

    @After
    fun teardown() {
        deviceListViewModel.objectState.removeObserver(observer)
    }

}
