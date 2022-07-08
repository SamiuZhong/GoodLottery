package com.samiu.lottery.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 双色球组件 6+1
 *
 * @author samiu
 * @email samiuzhong@outlook.com
 */
@Composable
fun SsqCompo(
    redCodeList: List<String>,
    blueCode: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        for (code in redCodeList) {
            LotButton(
                number = code,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = Color.Red
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        LotButton(
            number = blueCode,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f),
            color = Color.Blue
        )
    }
}