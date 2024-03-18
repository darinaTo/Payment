package com.example.payment_app.domain.entities.dbEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.payment_app.data.constants.Constants.TRANSACTION_TABLE


@Entity(tableName = TRANSACTION_TABLE)
data class TransactionDbEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "createData") val createData: String,
    @ColumnInfo(name = "cardId") val carId: String
)