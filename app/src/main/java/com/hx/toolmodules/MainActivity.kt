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
        vm.login(){

        }
    }
}
