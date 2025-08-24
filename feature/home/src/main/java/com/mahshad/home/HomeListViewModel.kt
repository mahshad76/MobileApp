package com.mahshad.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahshad.model.data.Object
import com.mahshad.repository.ObjectRepository
import com.mahshad.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(private val objectRepository: ObjectRepository) :
    ViewModel() {
    ///defining states as state flow or live data, call the repository functions, and set the value
    ///of the states
    private val _objectsState: MutableLiveData<Result<List<Object>>?> =
        MutableLiveData(null)
    val objectState: LiveData<Result<List<Object>>?> = _objectsState

    fun updateObjectsList() {
        _objectsState.value = Result.Loading
        viewModelScope.launch {
            val result = objectRepository.getObjects()
            _objectsState.value = result
        }
    }
}