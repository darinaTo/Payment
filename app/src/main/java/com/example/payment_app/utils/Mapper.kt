package com.example.payment_app.utils

import com.example.payment_app.domain.entities.networkEntities.transaction.Transaction
import com.example.payment_app.domain.entities.uiEntity.TransactionEntityUi

fun List<Transaction>.mapToUEntity(): List<TransactionEntityUi> =
    this.mapNotNull { transaction ->
        transaction.card?.let { card ->
            TransactionEntityUi(
                card = card,
                amount = transaction.amount,
                createData = transaction.createDate
            )
        }
    }
