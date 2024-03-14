package com.example.payment_app.ui.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.payment_app.R

@Composable
fun TransactionItem(
    last4: String?, amount: Double, logo: String?
    , name: String?, iconSize: Dp = 40.dp, modifier: Modifier
) {


    val textColor = if (amount < 0) Color.Black else Color.Green
    val amountText = if (amount > 0) "$${amount}" else "-$${amount}"
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = logo,
            contentScale = ContentScale.Crop,
            contentDescription = "logo",
            modifier = Modifier
                .size(iconSize)
                .clip(CircleShape)
        )
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            name?.let { Text(text = it,
                fontSize = 15.sp) }
            last4?.let { Text(text = "•• $it",
                fontSize = 10.sp) }
        }
        Spacer(Modifier.weight(1f))

        Text(
            text = amountText,
            color = textColor
        )

        Image(
            painter = painterResource(R.drawable.card_approve),
            modifier = Modifier.size(20.dp),
            contentDescription = null
        )
    }
}
