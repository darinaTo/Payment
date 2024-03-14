package com.example.payment_app.utils

import com.example.payment_app.domain.entities.networkEntities.card.Card
import com.example.payment_app.domain.entities.networkEntities.transaction.Transaction

data class UiState (
    val status : Status = Status.LOADING,
    val cards: List<Card> = emptyList(),
    val transaction: List<Transaction> = emptyList()
)