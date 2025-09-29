package com.mahshad.home.homebasketfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahshad.model.data.Object
import com.mahshad.repository.offlinerepository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@HiltViewModel
class HomeBasketViewModel @Inject constructor(
    private val basketRepository:
    BasketRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeBasketUiEvent> =
        MutableStateFlow(HomeBasketUiEvent.Loading)
    val uiState: StateFlow<HomeBasketUiEvent> = _uiState

    fun updateUiState() {
        viewModelScope.launch {
            basketRepository
                .selectAll()
                .catch { e: Throwable ->
                    _uiState.value = HomeBasketUiEvent.Error(e)
                }
                .collect { basketObjects: List<Object> ->
                    _uiState.value = HomeBasketUiEvent.Successful(basketObjects)
                }
        }
    }
}

sealed interface HomeBasketUiEvent {
    data class Successful(val devices: List<Object>) : HomeBasketUiEvent
    data class Error(val e: Throwable) : HomeBasketUiEvent
    data object Loading : HomeBasketUiEvent
}