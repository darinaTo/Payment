package com.example.payment_app.domain.entities.dbEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.payment_app.data.constants.Constants.CARD_TABLE

@Entity(
    CARD_TABLE,
    foreignKeys = [ForeignKey(
        entity = TransactionDbEntity::class,
        parentColumns = ["id"],
        childColumns = ["transactionId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CardDbEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "cardId") val cardId: String,
    @ColumnInfo(name = "transactionId")
    val transactionId: String,
    @ColumnInfo(name = "logo") val logo: String,
    @ColumnInfo(name = "Last4") val last4: String,
    @ColumnInfo(name = "name") val name: String,
)
