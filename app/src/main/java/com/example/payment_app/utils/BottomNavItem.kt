package com.example.payment_app.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Payment
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val title: String,
    val icon: ImageVector,
) {
    object Home : BottomNavItem(title = "Home", icon = Icons.Outlined.Home)
    object Transaction : BottomNavItem(title = "Transaction", icon = Icons.Outlined.List)
    object Accounts : BottomNavItem(title = "Accounts", icon = Icons.Outlined.AccountBox)
    object Card : BottomNavItem(title = "My card", icon = Icons.Outlined.Payment)
}
