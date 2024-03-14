package com.example.payment_app.domain.entities.networkEntities.transaction

data class Account(
    val accountLast4: String,
    val accountName: String,
    val accountType: String
)