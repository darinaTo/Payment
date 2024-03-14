package com.example.payment_app.ui.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.payment_app.R

@Composable
fun TransactionItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.AccountBox,
            // contentScale = ContentScale.Crop,
            contentDescription = "icon"
        )
        /* AsyncImage(model = Icons.Default.AccountBox,
             contentScale = ContentScale.Crop,
             contentDescription = "icon")*/
        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
            Text(text = "Slack")
            Text(text = "7544")
        }
        Spacer(Modifier.weight(1f))

        Text(text = "-29.47")

        Icon(painter = painterResource(R.drawable.receipt_added),
            modifier = Modifier.size(15.dp),
            contentDescription = null)
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
private fun TransactionItemPriview() {
    TransactionItem()
}