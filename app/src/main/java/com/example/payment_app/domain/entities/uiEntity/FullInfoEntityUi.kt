package com.example.payment_app.domain.entities.uiEntity

import com.example.payment_app.domain.entities.dbEntities.TransactionDbEntity

data class FullInfoEntityUi(
    val transactionInfo: TransactionDbEntity,
    val card: CardUiEntity
)


