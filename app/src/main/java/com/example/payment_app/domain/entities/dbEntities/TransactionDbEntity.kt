package com.example.payment_app.domain.entities.dbEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.payment_app.data.constants.Constants.TRANSACTION_TABLE


@Entity(tableName = TRANSACTION_TABLE)
data class TransactionDbEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: String = "",
    val amount : Double,
    val createData : String
)