package com.example.payment_app.domain.entities.networkEntities.transaction

data class CardHolder(
    val email: String,
    val fullName: String,
    val id: String,
    val logoUrl: String
)