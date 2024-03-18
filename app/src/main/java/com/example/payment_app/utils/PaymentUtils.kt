package com.example.payment_app.utils

import androidx.compose.ui.graphics.Color
import com.example.payment_app.R
import com.example.payment_app.domain.entities.uiEntity.FullInfoEntityUi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.absoluteValue

fun String.formatDate(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    val date = LocalDate.parse(this, formatter)

    val monthFormatter = DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH)
    return monthFormatter.format(date)
}

fun Double.chooseColor(): Color =
    if (this < 0) Color.Black else Color.Green


fun Double.refactorText(): String =
    if (this > 0) "$${this}" else "-$${this.absoluteValue}"

fun Double.chooseIcon(logo: String): Any =
    if (this > 0) R.drawable.arrow_dwon_left else logo

fun List<FullInfoEntityUi>.groupBy(): Map<String, List<FullInfoEntityUi>> =
    this.groupBy { it.transactionInfo.createData }


