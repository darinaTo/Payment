package com.example.payment_app.domain.entities.networkEntities.transaction

data class TransactionApiEntity(
    val account: Account,
    val amount: Double,
    val attachments: List<Attachment>,
    val card: Card,
    val category: Any,
    val completeDate: String,
    val createDate: String,
    val id: String,
    val merchant: Merchant,
    val origin: String,
    val publicId: String,
    val status: String,
    val type: String
)