package com.example.payment_app.utils

import com.example.payment_app.domain.entities.dbEntities.CardDbEntity
import com.example.payment_app.domain.entities.dbEntities.TransactionDbEntity
import com.example.payment_app.domain.entities.networkEntities.card.CardsApiEntity
import com.example.payment_app.domain.entities.networkEntities.transaction.Transaction
import com.example.payment_app.domain.entities.uiEntity.CardUiEntity
import com.example.payment_app.domain.entities.uiEntity.TransactionUiEntity


fun List<Transaction>.mapToUEntity(): List<TransactionUiEntity> =
    this.mapNotNull { transaction ->
        transaction.card?.let { card ->
            TransactionUiEntity(
                id = transaction.publicId,
                card = card,
                amount = transaction.amount,
                createData = transaction.createDate
            )
        }
    }

fun CardsApiEntity.mapToDbEntity(transactionId: String): CardDbEntity =
    CardDbEntity(
        transactionId = transactionId,
        cardId = id,
        logo = cardHolder.logoUrl,
        last4 = cardLast4,
        name = cardName
    )

fun List<CardDbEntity>.mapToUiEntity(): List<CardUiEntity> =
    this.map {
        CardUiEntity(
            id = it.cardId,
            logo = it.logo,
            cardLast4 = it.last4,
            cardName = it.name
        )
    }

fun List<TransactionUiEntity>.mapToDbEntity(): List<TransactionDbEntity> =
    this.map { transaction ->
        TransactionDbEntity(
            id = transaction.id,
            amount = transaction.amount,
            createData = transaction.createData,
            carId = transaction.card.id
        )
    }
