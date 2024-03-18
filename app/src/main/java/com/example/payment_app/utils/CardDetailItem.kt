package com.example.payment_app.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCardOff
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.ui.graphics.vector.ImageVector

sealed class CardDetailItem(
    val title: String,
    val icon: ImageVector,
) {
    object Eye : CardDetailItem(title = "Detail", icon = Icons.Outlined.RemoveRedEye)
    object Lock : CardDetailItem(title = "Lock", icon = Icons.Outlined.Lock)
    object CreditCard : CardDetailItem(title = "Terminate", icon = Icons.Outlined.CreditCardOff)
}