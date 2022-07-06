package com.hx.toolmodules

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.hx.networkmodule.NetworkUtils
import com.hx.networkmodule.Resp
import com.hx.toolmodules.network.TestService
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {
    val netWork = NetworkUtils("http://192.168.3.224:8300/", TestService::class.java)
    fun login(resp:(data:Resp<LoginEntity>)->Unit) {
        netWork.connect(
            flow { emit(netWork.start().login(LoginData("qdjhzt", "MQ=="))) },
            viewModelScope
        ) { resp ->
            resp(resp)
        }
    }
}

data class LoginEntity(
    val areaId: String,
    val areaName: String,
    val dataScope: Int,
    val isAdmin: Any,
    val isAgency: Any,
    val isCentralOffice: Any,
    val isFire: Any,
    val isGov: Any,
    val isGrid: Any,
    val isIndustry: Any,
    val isSelfRole: Any,
    val isSocial: Any,
    val jwt: String,
    val mqttTopic: String,
    val officeId: String,
    val officeName: String,
    val officeType: Int,
    val parentId: String,
    val parentIds: String,
    val photoUrl: String,
    val roleId: String,
    val roleName: String,
    val userId: String,
    val userName: String
)

data class LoginData(
    val loginName: String,
    val password: String
)