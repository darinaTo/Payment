package com.example.payment_app.ui.activity.mainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.payment_app.R
import com.example.payment_app.data.constants.BOTTOM_NAV_ITEMS
import com.example.payment_app.domain.entities.uiEntity.CardUiEntity
import com.example.payment_app.domain.entities.uiEntity.TransactionUiEntity
import com.example.payment_app.ui.theme.Grey
import com.example.payment_app.ui.theme.LightBlue
import com.example.payment_app.ui.viewmodels.PaymentViewModel
import com.example.payment_app.utils.BottomNavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onIconTap: (String) -> Unit,
    viewModel: PaymentViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val commonModifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .background(MaterialTheme.colorScheme.surface)

    Scaffold(
        topBar = {
            TopBarNavigation()
        },
        bottomBar = {
            BottomBarNavigation(items = BOTTOM_NAV_ITEMS)

        }) { paddingValues ->
        BaseScreen(
            modifier = Modifier.padding(paddingValues),
            onIconTap = onIconTap,
            cards = uiState.cards,
            transactions = uiState.transaction,
            commonModifier = commonModifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarNavigation() {
    TopAppBar(
        title = {
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
                        painter = painterResource(item.icon),
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
                    unselectedIconColor = Grey,
                    selectedTextColor = LightBlue
                ),
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}

@Composable
fun BaseScreen(
    modifier: Modifier, cards: List<CardUiEntity>,
    commonModifier: Modifier,
    transactions: List<TransactionUiEntity>,
    onIconTap: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(
                vertical = 24.dp,
                horizontal = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TopScreenPayment(
            modifier = commonModifier
        )
        CardsScreenPayment(
            onIconTap = onIconTap,
            cards = cards,
            modifier = commonModifier,
        )
        TransactionPaymentScreen(
            transactions = transactions,
            modifier = commonModifier
        )
    }
}


@Composable
fun TopScreenPayment(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier.padding(14.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.united_states_of_america),
                contentDescription = "currency"
            )
            Text(
                text = "USD account",
                fontSize = 15.sp,
                modifier = Modifier.padding(6.dp),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Text(
            text = "$100,000",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}


@Composable
fun CardsScreenPayment(modifier: Modifier, cards: List<CardUiEntity>, onIconTap: (String) -> Unit) {
    Column(
        modifier = modifier
    ) {
        HeadOfSectionScreen(text = stringResource(R.string.my_cards))
        LazyColumn {
            items(cards) { card ->
                CardItem(
                    onIconTap = onIconTap,
                    cards = card
                )
            }
        }
    }
}

@Composable
fun TransactionPaymentScreen(modifier: Modifier, transactions: List<TransactionUiEntity>) {
    Column(modifier = modifier) {
        HeadOfSectionScreen(text = stringResource(R.string.recent_transaction))
        LazyColumn {
            items(transactions) { transaction ->
                TransactionItem(
                    modifier = modifier,
                    last4 = transaction.card.cardLast4,
                    amount = transaction.amount,
                    logo = transaction.card.cardHolder.logoUrl,
                    name = transaction.card.cardName
                )
            }
        }
    }
}


@Composable
fun HeadOfSectionScreen(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.see_all),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            color = Grey
        )
    }
}

