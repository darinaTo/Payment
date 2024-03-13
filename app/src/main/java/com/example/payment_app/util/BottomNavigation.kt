package com.example.payment_app.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title : String,
    val icon : ImageVector,
    val selectedColor: Color = Color.Blue,
)
