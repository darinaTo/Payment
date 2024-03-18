package com.example.payment_app.ui.activity.mainPage

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.payment_app.R
import com.example.payment_app.utils.chooseColor
import com.example.payment_app.utils.chooseIcon
import com.example.payment_app.utils.refactorText

@Composable
fun TransactionItem(
    last4: String,
    amount: Double,
    logo: Any,
    name: String,
    iconSize: Dp = 40.dp,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {

        TransactionIconImage(iconSize = iconSize, amount = amount, logo = logo)

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = name,
                fontSize = 15.sp
            )
            if (last4 != "") {
                Text(
                    text = stringResource(R.string.doubleDoc, last4),
                    fontSize = 10.sp
                )
            }
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

@Composable
fun TransactionIconImage(
    iconSize: Dp,
    amount: Double,
    logo: Any
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(iconSize + 10.dp)
            .clip(CircleShape)
            .background(Color.Gray)
    ) {
        if (logo != "") {
            AsyncImage(
                model = amount.chooseIcon(logo.toString()),
                contentDescription = "logo",
                modifier = Modifier
                    .size(if (amount > 0) iconSize - 18.dp else iconSize)
                    .clip(if (amount > 0) RoundedCornerShape(0.dp) else CircleShape)
            )
        } else {
            Icon(
                painter = painterResource(R.drawable.card),
                contentDescription = "card",
                modifier = Modifier.size(30.dp),
                tint = Color.LightGray
            )
        }
    }
}