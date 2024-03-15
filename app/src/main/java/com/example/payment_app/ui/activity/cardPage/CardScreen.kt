package com.example.payment_app.ui.activity.cardPage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.payment_app.data.constants.BOTTOM_NAV_ITEMS
import com.example.payment_app.ui.activity.mainPage.BottomBarNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen() {
    Scaffold(
        topBar = {
                 TopAppBar(title = { /*TODO*/ },
                     )
        },
        bottomBar = {
            BottomBarNavigation(items = BOTTOM_NAV_ITEMS)
        }
    ) { paddingValues ->
        DetailCardScreen(
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

@Composable
fun CardTopAppBar() {

}
@Composable
fun DetailCardScreen(modifier: Modifier) {

}
