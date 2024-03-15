package com.example.payment_app.domain.entities.networkEntities.card

data class Card(
    val cardHolder: CardHolder,
    val cardLast4: String,
    val cardName: String,
)