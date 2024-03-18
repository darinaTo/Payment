package com.example.payment_app.data.service.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.payment_app.domain.entities.dbEntities.CardDbEntity
import com.example.payment_app.domain.entities.dbEntities.PaymentFullInfo
import com.example.payment_app.domain.entities.dbEntities.TransactionDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTransaction(transaction: List<TransactionDbEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(cars: CardDbEntity)

    @Query("SELECT DISTINCT * FROM card GROUP BY cardId")
    fun getAllCards(): Flow<List<CardDbEntity>>

    @Query("SELECT * FROM `transaction`")
    fun getAllTransactions(): Flow<List<TransactionDbEntity>>

    @Transaction
    @Query("SELECT * FROM `transaction`  WHERE cardId = :cardId")
    fun getTransactionByCardId(cardId: String): Flow<List<PaymentFullInfo>>
}
