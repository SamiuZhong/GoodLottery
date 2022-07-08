package com.samiu.lottery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samiu.lottery.data.entiry.AimCode
import com.samiu.lottery.ui.navigation.Screen
import com.samiu.lottery.ui.state.AimUIState
import com.samiu.lottery.ui.theme.Typography
import com.samiu.lottery.ui.viewmodel.MxnViewModel

@Composable
fun MainRoute(
    navController: NavController,
    viewModel: MxnViewModel = hiltViewModel()
) {
    val aimState by viewModel.aimStateFlow.collectAsState()
    MainScreen(
        aimState = aimState,
        onClickHistory = { navController.navigate(Screen.History.router) },
        onQueryLot = viewModel::queryLottery
    )
}

@Composable
fun MainScreen(
    aimState: AimUIState,
    onClickHistory: () -> Unit,
    onQueryLot: (expect: String, aimCode: AimCode) -> Unit
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
                label = { Text(text = "彩票期号") },
                placeholder = { Text(text = "请输入期号") }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { onQueryLot(numberText.text, AimCode.SSQ) }
            ) {
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
        Button(onClick = { onClickHistory() }) {
            Text(text = "历史")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    MainScreen(
        AimUIState(),
        onQueryLot = { _, _ -> },
        onClickHistory = {}
    )
}