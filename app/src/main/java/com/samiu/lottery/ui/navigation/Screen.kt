package com.samiu.lottery.ui.navigation

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
sealed class Screen(val router: String) {
    object Home : Screen(router = "home_screen")
    object History : Screen(router = "history_screen")
}