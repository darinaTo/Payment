package com.example.payment_app.data.constants

import com.example.payment_app.utils.BottomNavItem

object Constants {
    const val MAIN_SCREEN_ROUTE = "main_screen_screen"
    const val CARD_SCREEN_ROUTE = "card_screen_screen"
    const val BASE_URL = "https://dev.spendbase.co/"
    const val TRANSACTION_TABLE = "transaction"
    const val CARD_TABLE = "card"
}
val BOTTOM_NAV_ITEMS = listOf(
    BottomNavItem.Home, BottomNavItem.Transaction,
    BottomNavItem.Card, BottomNavItem.Accounts
)

