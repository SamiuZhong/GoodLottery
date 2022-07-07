package com.samiu.lottery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.samiu.lottery.ui.screens.HistoryScreen
import com.samiu.lottery.ui.screens.MainScreen
import com.samiu.lottery.ui.state.AimState

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.router
    ) {
        composable(route = Screen.Home.router) {
            MainScreen(
                navController = navController,
                aimState = AimState(
                    openCode = "01,03,06,10,11,29+16",
                    name = "双色球",
                    time = "2018-11-18 21:18:20"
                )
            )
        }
        composable(route = Screen.History.router) {
            HistoryScreen(navController)
        }
    }
}