package com.example.payment_app.ui.activity.cardPage

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.payment_app.domain.entities.uiEntity.FullInfoEntityUi
import com.example.payment_app.ui.activity.mainPage.TransactionItem
import com.example.payment_app.ui.theme.Grey

@Composable
fun TransactionHistoryItem(listTransaction: Map<String, List<FullInfoEntityUi>>) {
    LazyColumn(modifier = Modifier.padding(horizontal = 10.dp)) {
        listTransaction.forEach { (date, transactions) ->
            item {
                Text(
                    text = date, color = Grey,
                    modifier = Modifier.padding(8.dp)
                )
                Divider(
                    color = Grey, thickness = 0.7.dp,
                )
            }
            items(transactions) {
                TransactionItem(last4 = "",
                    amount = it.transactionInfo.amount,
                    logo = "",
                    name = it.card.cardName,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth())
            }
        }
    }
}