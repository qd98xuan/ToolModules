package com.hx.toolmodules

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.hx.networkmodule.NetworkUtils
import com.hx.toolmodules.network.TestService
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {
    val netWork = NetworkUtils("http://192.168.3.224:8300/", TestService::class.java)
    fun login() {
        netWork.connect(
            flow { emit(netWork.start().login(LoginData("qdjhzt", "MQ=="))) },
            viewModelScope
        ) { success, data, error ->
            if (success) {
                Log.d("loginResp",Gson().toJson(data))
            } else {
                Log.d("loginError",error)
            }
        }
    }
}