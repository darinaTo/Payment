package com.example.payment_app.ui.activity.cardPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.payment_app.R
import com.example.payment_app.domain.entities.uiEntity.FullInfoEntityUi
import com.example.payment_app.ui.theme.Grey
import com.example.payment_app.ui.theme.LightBlack
import com.example.payment_app.ui.theme.LightGrey
import com.example.payment_app.utils.chooseColor
import com.example.payment_app.utils.groupBy
import com.example.payment_app.utils.refactorText

@Composable
fun TransactionHistoryItem(listTransaction: List<FullInfoEntityUi>) {
    val listMap = listTransaction.groupBy()
    LazyColumn(modifier = Modifier.padding(horizontal = 10.dp)) {
        listMap.forEach { (date, transactions) ->
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
                CardStatus(
                    amount = it.transactionInfo.amount,
                    name = it.card.cardName
                )
            }
        }
    }
}

@Composable
fun CardStatus(amount: Double, name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(LightGrey)
        ) {
            Icon(
                painter = painterResource(R.drawable.card),
                contentDescription = "card",
                modifier = Modifier.size(30.dp),
                tint = LightBlack
            )
        }
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = name,
                fontSize = 15.sp
            )
        }
        Spacer(Modifier.weight(1f))

        Text(
            text = amount.refactorText(),
            color = amount.chooseColor()
        )

        Image(
            painter = painterResource(R.drawable.card_approve),
            modifier = Modifier.size(20.dp),
            contentDescription = "approve"
        )
    }
}




