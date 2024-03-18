package com.example.payment_app.utils

import com.example.payment_app.domain.entities.dbEntities.CardDbEntity
import com.example.payment_app.domain.entities.dbEntities.TransactionDbEntity
import com.example.payment_app.domain.entities.networkEntities.card.CardsApiEntity
import com.example.payment_app.domain.entities.networkEntities.transaction.Transaction
import com.example.payment_app.domain.entities.uiEntity.TransactionEntityUi

fun List<Transaction>.mapToUEntity(): List<TransactionEntityUi> =
    this.mapNotNull { transaction ->
        transaction.card?.let { card ->
            TransactionEntityUi(
                id = transaction.publicId,
                card = card,
                amount = transaction.amount,
                createData = transaction.createDate
            )
        }
    }

fun List<TransactionEntityUi>.mapToDbEntity() : List<TransactionDbEntity> =
    this.map {transaction ->
            TransactionDbEntity(
                id = transaction.id,
                amount = transaction.amount,
                createData = transaction.createData
            )
        }

fun CardsApiEntity.mapToDbEntity(transactionId : String) : CardDbEntity =
    CardDbEntity(
        transactionId = transactionId,
        cardId = id,
        logo = cardHolder.logoUrl,
        last4 = cardLast4,
        name = cardName
    )