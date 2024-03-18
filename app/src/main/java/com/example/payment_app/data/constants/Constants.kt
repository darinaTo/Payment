package com.example.payment_app.data.constants

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.payment_app.utils.BottomNavItem
import com.example.payment_app.utils.CardDetailItem

object Constants {
    const val MAIN_SCREEN_ROUTE = "main_screen_screen"
    const val CARD_SCREEN_ROUTE = "card_screen_screen"
    const val BASE_URL = "https://dev.spendbase.co/"
    const val TRANSACTION_TABLE = "transaction"
    const val CARD_TABLE = "card"
    const val ERROR_MESSAGE = "Some trouble with network connection"

    val paymentArg = listOf(
        navArgument("id") {
            type = NavType.StringType
        }
    )
}

val BOTTOM_NAV_ITEMS = listOf(
    BottomNavItem.Home, BottomNavItem.Transaction,
    BottomNavItem.Card, BottomNavItem.Accounts
)
val CARD_DETAIL_ITEMS = listOf(
    CardDetailItem.Eye, CardDetailItem.Lock, CardDetailItem.CreditCard
)

