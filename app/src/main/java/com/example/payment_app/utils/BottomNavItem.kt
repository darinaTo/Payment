package com.example.payment_app.utils

import com.example.payment_app.R

sealed class BottomNavItem(
    val title: String,
    val icon: Int,
) {
    object Home : BottomNavItem(title = "Home", icon = R.drawable.home)
    object Transaction : BottomNavItem(title = "Transaction", icon = R.drawable.trasnaction)
    object Accounts : BottomNavItem(title = "Accounts", icon = R.drawable.user_square)
    object Card : BottomNavItem(title = "My card", icon = R.drawable.card)
}
