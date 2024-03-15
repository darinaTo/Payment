package com.example.payment_app.domain.entities.dbEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.payment_app.data.constants.Constants.TRANSACTION_TABLE


@Entity(tableName = TRANSACTION_TABLE)
data class TransactionDbEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    val amount : Double,
    val createData : String
)