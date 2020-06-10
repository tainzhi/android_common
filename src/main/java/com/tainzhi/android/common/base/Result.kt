package com.tainzhi.android.common.base

import java.io.Serializable

/**
 * @author:       tainzhi
 * @mail:         qfq61@qq.com
 * @date:         2020/1/19 下午9:25
 * @description:
 **/

sealed class Result<out T : Any> : Serializable {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    data class NetUnavailable(val exception: Exception) : Result<Nothing>()
    
    
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is NetUnavailable -> "Error[exception=$exception]"
        }
    }
}