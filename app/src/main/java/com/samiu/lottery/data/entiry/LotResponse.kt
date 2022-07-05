package com.samiu.lottery.data.entiry

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
data class LotResponse<out T>(val code: Int, val msg: String, val data: T?)