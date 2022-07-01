package com.hx.networkmodule

import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import java.util.*

/**
 * 网络请求统一工具
 */
class NetworkUtils<T> constructor(baseUrl: String,service: Class<T>) {
    private val baseUrl = baseUrl
    private val service = service
    private fun getRetorfit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .build()
    fun start(): T = getRetorfit().create(service)
    fun <T> connect(flow: Flow<T>) {
        flow
    }
}

data class BaseResp<T>(
    val code: Int,
    val data: T,
    val msg: String
)