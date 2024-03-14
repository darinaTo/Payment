package com.example.payment_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.payment_app.data.impl.PaymentRepository
import com.example.payment_app.utils.Status
import com.example.payment_app.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
private val cardRepository: PaymentRepository)
    :ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
        init {
            viewModelScope.launch {
                val cardList = cardRepository.getCardList()
                if (cardList.isSuccess) {
                    _uiState.update { it.copy(status = Status.SUCCESS,
                        cards = cardList.getOrDefault(emptyList())) }
                } else {
                    _uiState.update { it.copy(status = Status.ERROR) }
                }
            }
        }
}