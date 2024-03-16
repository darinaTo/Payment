package com.example.payment_app.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.payment_app.data.impl.PaymentRepository
import com.example.payment_app.utils.UiStateCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class CardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val paymentRepository: PaymentRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiStateCard())
    val uiState: StateFlow<UiStateCard> = _uiState.asStateFlow()
    private val id : String
    init {
        id = requireNotNull(savedStateHandle.get<String>("id"))
    }


    private suspend fun getFullInfo() {
        paymentRepository.getTransactionByCardID(id).onEach {info  ->
            _uiState.update { it.copy(fullInfo = info) }
        }.launchIn(viewModelScope)
    }
}