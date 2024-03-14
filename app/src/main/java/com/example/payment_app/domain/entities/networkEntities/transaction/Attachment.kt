package com.example.payment_app.domain.entities.networkEntities.transaction

data class Attachment(
    val createdAt: String,
    val deletedAt: Any?,
    val externalTransactionId: String,
    val fileName: String,
    val fileSize: String,
    val fileType: String,
    val fileUrl: String,
    val id: String,
    val note: String,
    val sourceId: String,
    val transactionId: String,
    val updatedAt: String
)