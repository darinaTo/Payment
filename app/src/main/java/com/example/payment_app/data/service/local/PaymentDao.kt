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
    suspend fun insertCard(cars : CardDbEntity)

    /*SELECT * FROM `transaction` left join card on transactionId = transactionId" +
            " where cardId =:cardId group by transactionId*/
    @Transaction
    @Query("SELECT * FROM `transaction` left join card on transactionId = transactionId" +
            " where cardId =:cardId")
     fun getTransactionByCardId(cardId : String) : Flow<List<PaymentFullInfo>>
}