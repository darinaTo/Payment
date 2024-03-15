package com.example.payment_app.domain.entities.networkEntities.transaction

import com.example.payment_app.domain.entities.networkEntities.card.CardsApiEntity

data class Transaction(
    val account: Account,
    val amount: Double,
    val attachments: List<Attachment>,
    val card: CardsApiEntity?,
    val category: Any?,
    val completeDate: String,
    val createDate: String,
    val id: String,
    val origin: String,
    val publicId: String,
    val status: String,
    val type: String
)