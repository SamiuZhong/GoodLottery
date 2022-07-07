package com.samiu.lottery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

    companion object {
        private const val TAG = "MainActivity##"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoodLotteryTheme {
                MainScreen(
                    AimState(
                        openCode = "01,03,06,10,11,29+16",
                        name = "双色球",
                        time = "2018-11-18 21:18:20"
                    )
                )
            }
        }
    }
}