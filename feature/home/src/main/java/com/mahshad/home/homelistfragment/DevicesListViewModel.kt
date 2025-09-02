package com.mahshad.home.homelistfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahshad.common.throttleFirst
import com.mahshad.model.data.Object
import com.mahshad.repository.databaserepository.BasketRepository
import com.mahshad.repository.objectrepository.DeviceRepository
import com.mahshad.repository.objectrepository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevicesListViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository,
    private val basketRepository: BasketRepository
) : ViewModel() {
    private val _clickState: MutableStateFlow<Object?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            _clickState
                .throttleFirst(300L)
                .collect { clickedObject ->
                    clickedObject?.let {
                        basketRepository.insert(it)
                    }
                }
        }
    }

    private val _objectsState: MutableLiveData<Result<List<Object>>?> =
        MutableLiveData(null)
    val objectState: LiveData<Result<List<Object>>?> = _objectsState

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _objectsState.value = Result.Error(throwable as Exception)
    }

    fun updateObjectsList() {
        _objectsState.value = Result.Loading
        viewModelScope.launch(coroutineExceptionHandler) {
            val result = deviceRepository.getObjects()
            _objectsState.value = result
        }
    }

    fun addButtonClickListener(clickedObject: Object) {
        _clickState.value = clickedObject
    }
}