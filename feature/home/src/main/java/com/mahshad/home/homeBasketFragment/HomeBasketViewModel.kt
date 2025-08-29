package com.mahshad.home.homeBasketFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahshad.model.data.Object
import com.mahshad.repository.databaserepository.DataBaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeBasketViewModel @Inject constructor(
    private val dataBaseRepository:
    DataBaseRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<List<Object>?> = MutableStateFlow(null)
    val uiState: StateFlow<List<Object>?> = _uiState

    fun updateUiState() {
        viewModelScope.launch {
            dataBaseRepository
                .selectAll()
                .collect { basketObjects: List<Object> ->
                    _uiState.value = basketObjects
                }
        }
    }

    private fun bookmarkDevice(id: String) {}

    fun onEvent(event: HomeBasketUiEvent) {
        when (event) {
            HomeBasketUiEvent.GetDevices -> updateUiState()
            is HomeBasketUiEvent.BookmarkDevice -> bookmarkDevice(event.id)
        }
    }
}
//sealed interface HomeBasketUiState {
//    data object Intial: HomeBasketUiState
//    data class Error(val message: String): HomeBasketUiState
//    data class Success()
//}

sealed interface HomeBasketUiEvent {
    data object GetDevices : HomeBasketUiEvent
    data class BookmarkDevice(val id: String) : HomeBasketUiEvent
}