package com.samiu.lottery.data.repository

import com.samiu.lottery.api.MxnApiService
import com.samiu.lottery.data.entiry.AimCode
import com.samiu.lottery.data.entiry.AimDto
import com.samiu.lottery.data.entiry.LotResult
import com.samiu.lottery.util.ResFilter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
class MxnRepository @Inject constructor(private val service: MxnApiService) {

    fun queryLottery(expect: String, aimCode: AimCode): Flow<LotResult<AimDto>> = flow {
        val response = service.queryAimLottery(expect, aimCode.code)
        val result = ResFilter.filterMxn(response)
        emit(result)
    }.flowOn(Dispatchers.IO)
}