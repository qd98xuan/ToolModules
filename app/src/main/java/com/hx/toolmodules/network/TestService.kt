package com.hx.toolmodules.network

import com.hx.networkmodule.BaseResp
import com.hx.toolmodules.LoginData
import com.hx.toolmodules.LoginEntity
import retrofit2.http.Body
import retrofit2.http.POST

interface TestService {
    @POST("system/public/login")
    suspend fun login(
        @Body data: LoginData
    ):BaseResp<LoginEntity>
}