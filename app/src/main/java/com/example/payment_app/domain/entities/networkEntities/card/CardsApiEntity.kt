package com.example.payment_app.domain.entities.networkEntities.card

data class CardsApiEntity(
    val id: String,
    val cardHolder: CardHolder,
    val cardLast4: String,
    val cardName: String,
)
