package com.example.payment_app.utils

import com.example.payment_app.domain.entities.uiEntity.FullInfoEntityUi

data class UiStateCard(
    val id: String = "",
    val status: Status = Status.LOADING,
    val fullInfo : List<FullInfoEntityUi> = emptyList()
)