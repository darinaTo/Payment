package com.example.payment_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.payment_app.data.constants.Constants.ERROR_MESSAGE
import com.example.payment_app.data.impl.PaymentRepository
import com.example.payment_app.utils.Status
import com.example.payment_app.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val paymentRepository: PaymentRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val errorFlow = paymentRepository.errorFlow.onEach {
        _uiState.update { it.copy(errorMessage = ERROR_MESSAGE) }
    }

    init {
        viewModelScope.launch {
            getCard()
            getTransaction()
        }
    }

    private suspend fun getCard() {
        paymentRepository.getCard().onEach { card ->
            _uiState.update { it.copy(status = Status.SUCCESS, cards = card) }
        }.launchIn(viewModelScope)
    }

    private suspend fun getTransaction() {
        val transaction = paymentRepository.getTransaction()
        if (transaction.isSuccess) {
            _uiState.update {
                it.copy(status = Status.SUCCESS, transaction = transaction.getOrDefault(emptyList()))}
        } else {
            _uiState.update { it.copy(status = Status.ERROR) }
        }
    }


}