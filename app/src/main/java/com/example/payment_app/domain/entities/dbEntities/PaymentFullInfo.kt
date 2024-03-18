package com.example.payment_app.domain.entities.dbEntities

import androidx.room.Embedded
import androidx.room.Relation

data class PaymentFullInfo(
    @Embedded val transaction: TransactionDbEntity,
    @Relation(parentColumn = "id", entityColumn = "transactionId")
    val card: CardDbEntity
)
