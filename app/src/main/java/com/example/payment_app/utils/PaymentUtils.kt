package com.example.payment_app.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.formatDate(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
    val date = LocalDate.parse(this, formatter)

    val monthFormatter = DateTimeFormatter.ofPattern("MMMM dd", Locale.ENGLISH)
    return monthFormatter.format(date)
}