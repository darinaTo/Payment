package com.example.payment_app.utils

import com.example.payment_app.domain.entities.dbEntities.PaymentFullInfo

data class UiStateCard(
    val id: String = "",
    val status: Status = Status.LOADING,
    val fullInfo : List<PaymentFullInfo> = emptyList()
)