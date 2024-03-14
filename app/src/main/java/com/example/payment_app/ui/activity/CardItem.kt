package com.example.payment_app.ui.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CardItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
    Card()

        Text(text = "Slack")
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = "see detail",

            )
    }

}


@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    CardItem()
}

@Composable
fun Card() {
        Box(
            modifier = Modifier
                .size(width = 50.dp, height = 35.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color.Gray)

        )
        Icon(
            imageVector = Icons.Rounded.AddCircle,
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .offset(y = (-15).dp, x = (-60).dp)
        )
}