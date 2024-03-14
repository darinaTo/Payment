package com.example.payment_app.data.impl

import com.example.payment_app.data.remote.PaymentApi
import com.example.payment_app.domain.entities.networkEntities.card.Card
import com.example.payment_app.domain.entities.networkEntities.transaction.Transaction
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PaymentRepository @Inject constructor(
    private val api: PaymentApi
) {

    suspend fun getCardList(): Result<List<Card>> =
        runCatching {
            api.getCards().cards
        }.onSuccess { card  ->
            Result.success(card)
        }.onFailure { ex ->
            Result.failure<Exception>(ex)
        }

    suspend fun getTransaction() : Result<List<Transaction>> =
        runCatching {
            api.getTransaction().transactions
        }.onSuccess { transaction ->
            Result.success(transaction)
        }.onFailure { ex ->
            Result.failure<Exception>(ex)
        }
}