package com.example.payment_app.utils

import com.example.payment_app.domain.entities.networkEntities.card.CardsApiEntity
import com.example.payment_app.domain.entities.uiEntity.TransactionEntityUi

data class UiState (
    val status : Status = Status.LOADING,
    val cards: List<CardsApiEntity> = emptyList(),
    val transaction: List<TransactionEntityUi> = emptyList()
)