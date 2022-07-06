package com.hx.toolmodules

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hx.networkmodule.NetworkUtils
import com.hx.toolmodules.network.TestService
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.callback.RequestCallback
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {
    val vm by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionX.init(this).permissions(
            Manifest.permission.INTERNET
        ).request { allGranted, grantedList, deniedList ->
            if (allGranted) {
                vm.login()
            }
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