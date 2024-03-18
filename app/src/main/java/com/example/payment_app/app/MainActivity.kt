package com.example.payment_app.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.payment_app.data.constants.Constants.CARD_SCREEN_ROUTE
import com.example.payment_app.data.constants.Constants.MAIN_SCREEN_ROUTE
import com.example.payment_app.data.constants.Constants.paymentArg
import com.example.payment_app.ui.activity.cardPage.CardScreen
import com.example.payment_app.ui.activity.mainPage.MainScreen
import com.example.payment_app.ui.theme.Payment_appTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Payment_appTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = MAIN_SCREEN_ROUTE) {
                    composable(MAIN_SCREEN_ROUTE) {
                        MainScreen(onIconTap = { id ->
                            navController.navigate("$CARD_SCREEN_ROUTE/${id}")
                        })
                    }
                    composable(
                        "$CARD_SCREEN_ROUTE/{id}",
                        arguments = paymentArg
                    ) {
                        CardScreen(
                            onArrowBackClick = { navController.popBackStack() }
                        )
                    }
                }
            }

        }
    }
}