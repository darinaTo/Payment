package com.example.payment_app.data.service.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.payment_app.domain.entities.dbEntities.CardDbEntity
import com.example.payment_app.domain.entities.dbEntities.TransactionDbEntity

@Database(
    entities = [TransactionDbEntity::class, CardDbEntity::class],
    version = 1, exportSchema = false
)
abstract class PaymentDatabase : RoomDatabase() {
    abstract fun paymentDao() : PaymentDao
}