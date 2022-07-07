package com.samiu.lottery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
@Composable
fun HistoryScreen(
    navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "历史页")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "返回")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHistory() {
    HistoryScreen(navController = rememberNavController())
}