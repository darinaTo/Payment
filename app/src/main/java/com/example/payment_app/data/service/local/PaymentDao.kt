package com.example.payment_app.data.service.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.payment_app.domain.entities.dbEntities.CardDbEntity
import com.example.payment_app.domain.entities.dbEntities.TransactionDbEntity

@Dao
interface PaymentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTransaction(transaction: List<TransactionDbEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(cars : CardDbEntity)
}