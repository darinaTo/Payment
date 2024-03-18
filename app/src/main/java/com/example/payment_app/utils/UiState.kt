package com.example.payment_app.utils

import com.example.payment_app.domain.entities.uiEntity.CardUiEntity
import com.example.payment_app.domain.entities.uiEntity.TransactionUiEntity

data class UiState(
    val status: Status = Status.LOADING,
    val cards: List<CardUiEntity> = emptyList(),
    val transaction: List<TransactionUiEntity> = emptyList(),
    val errorMessage: String = ""
)