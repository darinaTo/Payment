package com.example.payment_app.ui.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.payment_app.ui.theme.Grey
import com.example.payment_app.ui.theme.LightBlack


@Composable
fun CardItem(name: String, logo: String, last4: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        CardScreen(
            logo = logo,
            last4 = last4
        )

        Text(text = name,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Left)
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = "see detail",
            tint = Grey)
    }

}

@Composable
fun CardScreen(
    iconSize: Dp = 30.dp,
    cardWidth: Dp = 50.dp,
    cardHeight: Dp = 35.dp,
    logo: String,
    last4: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(iconSize + cardHeight + cardWidth / 4.5f)
    ) {

        Box(
            modifier = Modifier
                .size(width = cardWidth, height = cardHeight)
                .clip(RoundedCornerShape(3.dp))
                .background(LightBlack)

        ) {
            Text(
                text = last4,
                color = Color.White,
                fontSize = 10.sp,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.BottomEnd)
            )
        }
        AsyncImage(
            model = logo,
            contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(iconSize)
                .align(Alignment.TopStart)
                .offset(y = cardHeight / 3, x = cardWidth / 10)
                .clip(CircleShape)
        )

    }
}