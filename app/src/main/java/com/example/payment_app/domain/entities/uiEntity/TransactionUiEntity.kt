package com.example.payment_app.domain.entities.uiEntity

import com.example.payment_app.domain.entities.networkEntities.card.CardsApiEntity

data class TransactionUiEntity (
    val id : String,
    val card : CardsApiEntity,
    val amount : Double,
    val createData : String
)