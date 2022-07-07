package com.samiu.lottery.data.entiry

/**
 * @author samiu
 * @email samiuzhong@outlook.com
 */
sealed class LotResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : LotResult<T>()
    data class Error(val msg:String) : LotResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$msg]"
        }
    }
}
