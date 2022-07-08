package com.samiu.lottery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.samiu.lottery.ui.screens.HistoryScreen
import com.samiu.lottery.ui.screens.MainRoute
import com.samiu.lottery.ui.screens.MainScreen
import com.samiu.lottery.ui.state.AimUIState

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
            MainRoute(navController = navController)
        }
        composable(route = Screen.History.router) {
            HistoryScreen(navController)
        }
    }
}