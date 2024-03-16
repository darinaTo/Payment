package com.example.payment_app.ui.activity.cardPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.payment_app.R
import com.example.payment_app.data.constants.BOTTOM_NAV_ITEMS
import com.example.payment_app.ui.activity.mainPage.BottomBarNavigation
import com.example.payment_app.ui.theme.Grey
import com.example.payment_app.ui.viewmodels.CardViewModel
import com.example.payment_app.utils.Status

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(
    viewModel: CardViewModel = hiltViewModel(),
    onArrowBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val listTransaction = uiState.fullInfo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        if (uiState.status == Status.LOADING) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

        } else {
            val card = listTransaction[1].card
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(18.dp)
                            ) {
                                AsyncImage(
                                    model = card.logo,
                                    contentDescription = "logo",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(CircleShape)

                                )
                                Text(
                                    text = card.name,
                                    fontSize = 15.sp
                                )
                                Text(
                                    text = stringResource(R.string.doubleDoc, card.last4),
                                    fontSize = 15.sp,
                                    color = Grey
                                )

                            }
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
    }
}


@Composable
fun DetailCardScreen(modifier: Modifier) {
    /*  AsyncImage(
          model = card[1].card.logo,
          contentDescription = "logo",
          contentScale = ContentScale.Crop,
          modifier = Modifier.size(20.dp)
      )*/
}
