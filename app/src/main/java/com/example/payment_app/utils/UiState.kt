package com.example.payment_app.utils

import com.example.payment_app.domain.entities.networkEntities.card.Card

data class UiState (
    val status : Status = Status.LOADING,
    val cards: List<Card> = emptyList()
)