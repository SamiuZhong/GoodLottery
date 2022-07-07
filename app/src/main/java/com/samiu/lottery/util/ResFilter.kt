package com.samiu.lottery.util

import android.util.Log
import com.samiu.lottery.data.entiry.LotResponse
import com.samiu.lottery.data.entiry.LotResult
import kotlinx.coroutines.coroutineScope

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
object ResFilter {

    private const val TAG = "ResFilter##"

    suspend fun <T : Any> filterMxn(response: LotResponse<T>): LotResult<T> {
        return coroutineScope {
            if (response.code == 1 && response.data != null) {
                Log.d(TAG, "filterMxn: success")
                LotResult.Success(response.data)
            } else {
                Log.d(TAG, "filterMxn: error[msg=${response.msg}]")
                LotResult.Error(response.msg)
            }
        }
    }
}