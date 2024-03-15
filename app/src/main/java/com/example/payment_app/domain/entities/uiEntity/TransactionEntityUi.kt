package com.example.payment_app.domain.entities.uiEntity

import com.example.payment_app.domain.entities.networkEntities.card.Card

data class TransactionEntityUi (
    val card : Card,
    val amount : Double,
    val createData : String
)