package com.example.payment_app.ui.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.payment_app.R
import com.example.payment_app.util.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    val items = listOf(
        BottomNavigationItem(
            title = stringResource(R.string.home),
            icon = Icons.Rounded.Home,
        ),
        BottomNavigationItem(
            title = stringResource(R.string.transaction),
            icon = Icons.Rounded.List,
        ),
        BottomNavigationItem(
            title = stringResource(R.string.accounts),
            icon = Icons.Rounded.AccountBox,
        ),
        BottomNavigationItem(
            title = stringResource(R.string.accounts),
            icon = ImageVector.vectorResource(R.drawable.card),
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = stringResource(R.string.money),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }, actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                    modifier = Modifier.size(20.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.account_balance),
                    contentDescription = "bank",
                    modifier = Modifier.size(20.dp)

                )
            }

        })
    },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        },

                        icon = {
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            ) {
                                val color = if (index == selectedItemIndex) {
                                    item.selectedColor
                                } else Color.Gray
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title,
                                    tint = color,
                                    modifier = Modifier.size(30.dp)
                                )

                                Text(
                                    text = item.title,
                                    color = color,
                                    fontSize = 12.sp
                                )
                            }

                        })
                }
            }
        }) { paddingValues ->
        TopPayment(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun TopPayment(modifier: Modifier) {

}

