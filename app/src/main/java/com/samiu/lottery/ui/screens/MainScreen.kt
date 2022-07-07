package com.samiu.lottery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samiu.lottery.ui.navigation.Screen
import com.samiu.lottery.ui.state.AimState
import com.samiu.lottery.ui.theme.Typography

@Composable
fun MainScreen(
    navController: NavController,
    aimState: AimState
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.Bottom) {
            var numberText by remember {
                mutableStateOf(TextFieldValue(""))
            }
            OutlinedTextField(
                value = numberText,
                onValueChange = { numberText = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(text = "彩票号码") },
                placeholder = { Text(text = "请输入号码") }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { }) {
                Text(text = "提交")
            }
        }
        Text(
            text = aimState.openCode, style = Typography.bodyLarge
        )
        Text(
            text = aimState.name, style = Typography.bodyLarge
        )
        Text(
            text = aimState.time, style = Typography.bodyLarge
        )
        Button(onClick = {
            navController.navigate(
                Screen.History.router
            )
        }) {
            Text(text = "历史")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    MainScreen(
        navController = rememberNavController(),
        AimState(
            openCode = "01,03,06,10,11,29+16", name = "双色球", time = "2018-11-18 21:18:20"
        )
    )
}