package com.samiu.lottery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.samiu.lottery.ui.screens.MainScreen
import com.samiu.lottery.ui.theme.GoodLotteryTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author samiu 2022/7/4
 * @email samiuzhong@outlook.com
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoodLotteryTheme {
                MainScreen()
            }
        }
    }
}