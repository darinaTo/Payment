package com.example.payment_app.data.impl

import com.example.payment_app.data.service.remote.PaymentApi
import com.example.payment_app.domain.entities.networkEntities.card.CardsApiEntity
import com.example.payment_app.domain.entities.uiEntity.TransactionEntityUi
import com.example.payment_app.utils.mapToUEntity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PaymentRepository @Inject constructor(
    private val api: PaymentApi
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
            Result.success(transaction)
        }.onFailure { ex ->
            Result.failure<Exception>(ex)
        }
}