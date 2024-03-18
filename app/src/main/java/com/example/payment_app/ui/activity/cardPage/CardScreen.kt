package com.example.payment_app.ui.activity.cardPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.payment_app.R
import com.example.payment_app.data.constants.BOTTOM_NAV_ITEMS
import com.example.payment_app.data.constants.CARD_DETAIL_ITEMS
import com.example.payment_app.domain.entities.uiEntity.CardUiEntity
import com.example.payment_app.domain.entities.uiEntity.FullInfoEntityUi
import com.example.payment_app.ui.activity.mainPage.BottomBarNavigation
import com.example.payment_app.ui.theme.Grey
import com.example.payment_app.ui.theme.LightBlack
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
            val card = listTransaction.values.first()[0].card
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            TopBarScreen(card = card)
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
                CardSectionScreen(
                    modifier = Modifier
                        .padding(paddingValues),
                    listTransaction = listTransaction
                )
            }
        }
    }
}

@Composable
fun TopBarScreen(card: CardUiEntity) {
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
            text = card.cardName,
            fontSize = 15.sp
        )
        Text(
            text = stringResource(R.string.doubleDoc, card.cardLast4),
            fontSize = 15.sp,
            color = Grey
        )

    }

}

@Composable
fun CardSectionScreen(modifier: Modifier, listTransaction: Map<String, List<FullInfoEntityUi>>) {
    Column(
        modifier = modifier
    ) {
        DetailCardScreen()
        TransactionHistory(listTransaction = listTransaction)
    }
}


@Composable
fun DetailCardScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(horizontal = 60.dp, vertical = 30.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(LightBlack)
                .fillMaxWidth()
                .height(100.dp)
                .padding(30.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.medium_logo),
                contentDescription = "logo"
            )
            Image(
                painter = painterResource(R.drawable.white_binoc),
                contentDescription = "card_logo"
            )
        }
        DetailCardSecondPartScreen()
    }
}

@Composable
fun DetailCardSecondPartScreen() {
    LazyRow(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .background(Color.White)
    ) {
        items(CARD_DETAIL_ITEMS) { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(10.dp)
            ) {
                Icon(imageVector = item.icon, contentDescription = "icon")
                Text(
                    text = item.title,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun TransactionHistory(listTransaction: Map<String, List<FullInfoEntityUi>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)

        ) {
            Text(
                text = stringResource(R.string.activity),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        TransactionHistoryItem(listTransaction = listTransaction)
    }
}