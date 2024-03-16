package com.example.payment_app.data.impl

import com.example.payment_app.data.service.local.PaymentDao
import com.example.payment_app.data.service.remote.PaymentApi
import com.example.payment_app.domain.entities.dbEntities.PaymentFullInfo
import com.example.payment_app.domain.entities.networkEntities.card.CardsApiEntity
import com.example.payment_app.domain.entities.uiEntity.TransactionEntityUi
import com.example.payment_app.utils.mapToDbEntity
import com.example.payment_app.utils.mapToUEntity
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityScoped
class PaymentRepository @Inject constructor(
    private val api: PaymentApi,
    private val dao: PaymentDao
) {

    suspend fun getCardList(): Result<List<CardsApiEntity>> =
        runCatching {
            api.getCards().cards
        }.onSuccess { card ->
            Result.success(card)
        }.onFailure { ex ->
            Result.failure<Exception>(ex)
        }

    suspend fun getTransaction(): Result<List<TransactionEntityUi>> =
        runCatching {
            api.getTransaction().transactions.mapToUEntity()
        }.onSuccess { transaction ->
            saveData(transaction)
            Result.success(transaction)
        }.onFailure { ex ->
            Result.failure<Exception>(ex)
        }
suspend fun getTransactionByCardID(cardId : String) : Flow<List<PaymentFullInfo>> =
    withContext(Dispatchers.IO) {
        dao.getTransactionByCardId(cardId)
    }


    private suspend fun saveData(transition: List<TransactionEntityUi>) {
        val toDbEntity = transition.mapToDbEntity()
        dao.insertAllTransaction(toDbEntity)
        transition.map { item ->
                dao.insertCard(item.card.mapToDbEntity(item.id))
        }
    }
}