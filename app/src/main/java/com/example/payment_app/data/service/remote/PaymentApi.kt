package com.example.payment_app.data.service.remote

import com.example.payment_app.domain.entities.networkEntities.card.Cards
import com.example.payment_app.domain.entities.networkEntities.transaction.TransactionApiEntity
import retrofit2.http.GET

interface PaymentApi {
    @GET("cards")
    suspend fun getCards() : Cards

    @GET("cards/transactions")
    suspend fun getTransaction() : TransactionApiEntity
}