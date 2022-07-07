package com.samiu.lottery.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samiu.lottery.ui.state.AimState
import com.samiu.lottery.ui.theme.Typography

@Composable
fun MainScreen(
    aimState: AimState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            LazyColumn(
                horizontalAlignment = Alignment.End
            ) {
                items(5) { index ->
                    Text(
                        text = "彩票${index + 1}",
                        style = Typography.bodyLarge
                    )
                }
            }
            Row {
                var text by remember {
                    mutableStateOf("输入彩票号码")
                }
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                )
                Button(onClick = { }) {

                }
            }
            Text(
                text = aimState.openCode,
                style = Typography.bodyLarge
            )
            Text(
                text = aimState.name,
                style = Typography.bodyLarge
            )
            Text(
                text = aimState.time,
                style = Typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    MainScreen(
        AimState(
            openCode = "01,03,06,10,11,29+16",
            name = "双色球",
            time = "2018-11-18 21:18:20"
        )
    )
}