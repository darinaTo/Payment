package com.example.payment_app.ui.activity

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.payment_app.R
import com.example.payment_app.ui.theme.LightBlue
import com.example.payment_app.util.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    val items = listOf(
        BottomNavItem.Accounts, BottomNavItem.Card,
        BottomNavItem.Home, BottomNavItem.Transaction
    )
    Scaffold(topBar = {
        TopBarNavigation()
    },
        bottomBar = {
            BottomBarNavigation(items = items)

        }) { paddingValues ->
        TopPayment(modifier = Modifier.padding(paddingValues))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarNavigation() {
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
}

@Composable
fun BottomBarNavigation(items: List<BottomNavItem>) {
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(-1) }
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { selectedItemIndex = index },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBlue,
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                        LocalAbsoluteTonalElevation.current
                    ),
                    selectedTextColor = LightBlue
                ),
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}

@Composable
fun TopPayment(modifier: Modifier) {

}

