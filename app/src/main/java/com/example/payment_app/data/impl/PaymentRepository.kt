package com.example.payment_app.data.impl

import com.example.payment_app.data.remote.PaymentApi
import com.example.payment_app.domain.entities.networkEntities.card.Card
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PaymentRepository @Inject constructor(
    private val api: PaymentApi
) {

    suspend fun getCardList(): Result<List<Card>> =
        runCatching {
            api.getCards().cards
        }.onSuccess { card : List<Card> ->
            Result.success(card)
        }.onFailure { ex : Throwable ->
            Result.failure<Exception>(ex)
        }

}