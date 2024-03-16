package com.example.payment_app.ui.activity.cardPage

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.payment_app.data.constants.BOTTOM_NAV_ITEMS
import com.example.payment_app.ui.activity.mainPage.BottomBarNavigation
import com.example.payment_app.ui.viewmodels.CardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(
    viewModel: CardViewModel = hiltViewModel(),
    onArrowBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    uiState.fullInfo
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                },
                navigationIcon = {
                    IconButton(onClick = { onArrowBackClick() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back navigate",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(25.dp)

                        )
                    }
                }
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
fun DetailCardScreen(modifier: Modifier) {

}
