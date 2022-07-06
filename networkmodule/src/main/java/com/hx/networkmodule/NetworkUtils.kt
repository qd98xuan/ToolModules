package com.hx.networkmodule

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/**
 * 网络请求统一工具
 */
class NetworkUtils<T> constructor(baseUrl: String,service: Class<T>) {
    private val baseUrl = baseUrl
    private val service = service
    private fun getRetorfit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun start(): T = getRetorfit().create(service)
    fun <T> connect(flow: Flow<T>,viewModeScope:CoroutineScope,resp:(success:Boolean,data:T?,error:String)->Unit ) {
        viewModeScope.launch(Dispatchers.IO){
            flow.catch {
                resp(false,null,it.message.toString())
            }.collect {
                resp(true,it,"")
            }
        }
    }
}

data class BaseResp<T>(
    val code: Int,
    val data: T,
    val msg: String
)