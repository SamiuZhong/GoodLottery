package com.samiu.lottery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.samiu.lottery.ui.navigation.SetupNavGraph
import com.samiu.lottery.ui.screens.MainScreen
import com.samiu.lottery.ui.state.AimState
import com.samiu.lottery.ui.theme.GoodLotteryTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author samiu 2022/7/4
 * @email samiuzhong@outlook.com
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoodLotteryTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}