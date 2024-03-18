package com.example.payment_app.data.impl

import com.example.payment_app.data.service.local.PaymentDao
import com.example.payment_app.data.service.remote.PaymentApi
import com.example.payment_app.domain.entities.uiEntity.CardUiEntity
import com.example.payment_app.domain.entities.uiEntity.FullInfoEntityUi
import com.example.payment_app.domain.entities.uiEntity.TransactionUiEntity
import com.example.payment_app.utils.mapToDbEntity
import com.example.payment_app.utils.mapToUEntity
import com.example.payment_app.utils.mapToUiEntity
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityScoped
class PaymentRepository @Inject constructor(
    private val api: PaymentApi,
    private val dao: PaymentDao
) {

    private val _errorFlow = MutableSharedFlow<Error>(
        replay = 1, onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val errorFlow = _errorFlow.asSharedFlow()
    suspend fun getCard(): Flow<List<CardUiEntity>> =
        withContext(Dispatchers.IO) {
            dao.getAllCards().also { flow ->
                if (flow.firstOrNull()?.isEmpty() == true) {
                    getCardList()
                }
            }.filterNotNull().map { it -> it.map { it.mapToUiEntity() } }
        }

    private suspend fun getCardList() {
        runCatching {
            api.getCards().cards
        }.onFailure { ex ->
            _errorFlow.tryEmit(Error(ex))
        }
    }

    suspend fun getTransaction(): Result<List<TransactionUiEntity>> =
        runCatching {
            api.getTransaction().transactions.mapToUEntity()
        }.onSuccess { transaction ->
            saveData(transaction)
        }.onFailure { ex ->
            _errorFlow.tryEmit(Error(ex))
        }

    suspend fun getTransactionByCardID(cardId: String): Flow<List<FullInfoEntityUi>> =
        withContext(Dispatchers.IO) {
            dao.getTransactionByCardId(cardId).map { it.mapToUiEntity() }
        }


    private suspend fun saveData(transition: List<TransactionUiEntity>) {
        val toDbEntity = transition.mapToDbEntity()
        dao.insertAllTransaction(toDbEntity)
        transition.map { item ->
            dao.insertCard(item.card.mapToDbEntity(item.id))
        }
    }
}