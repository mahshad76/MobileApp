package com.mahshad.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mahshad.model.data.Object
import com.mahshad.repository.ObjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(private val objectRepository: ObjectRepository) {
    ///defining states as state flow or live data, call the repository functions, and set the value
    ///of the states
    private val _objectsState: MutableLiveData<Result<List<Object>>?> =
        MutableLiveData(null)
    val objectState: LiveData<Result<List<Object>>?> =
        _objectsState

    fun updateObjectsList() {

        objectRepository.getObjects()
    }
}