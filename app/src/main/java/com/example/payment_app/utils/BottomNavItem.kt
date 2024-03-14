package com.example.payment_app.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Payment
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
) {
    object Home : BottomNavItem(title = "Home", icon = Icons.Rounded.Home)
    object Transaction : BottomNavItem(title = "Transaction", icon = Icons.Rounded.List)
    object Accounts : BottomNavItem(title = "Accounts", icon = Icons.Rounded.AccountBox)
    object Card : BottomNavItem(title = "My card", icon = Icons.Rounded.Payment)
}
