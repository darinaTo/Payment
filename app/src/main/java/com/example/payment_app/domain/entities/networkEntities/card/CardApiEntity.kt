package com.example.payment_app.domain.entities.networkEntities.card

data class CardApiEntity(
    val cardHolder: CardHolder,
    val cardLast4: String,
    val cardName: String,
    val fundingSource: String,
    val id: String,
    val isLocked: Boolean,
    val isTerminated: Boolean,
    val issuedAt: String,
    val limit: Int,
    val limitType: String,
    val spent: Int
)