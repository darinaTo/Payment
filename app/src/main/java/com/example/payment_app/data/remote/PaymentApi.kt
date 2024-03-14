package com.example.payment_app.data.remote

import com.example.payment_app.domain.entities.networkEntities.card.CardApiEntity
import com.example.payment_app.domain.entities.networkEntities.transaction.TransactionApiEntity
import retrofit2.http.GET

interface PaymentApi {
    @GET("cards")
    suspend fun getCards() : CardApiEntity

    @GET("cards/transactions")
    suspend fun getTransaction() : TransactionApiEntity
}