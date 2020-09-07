package com.arron.mydemo

import android.app.Application
import android.bluetooth.BluetoothDevice
import android.content.Context

/**

 * @Author Arron
 * @Date 2020/4/16 0016-21:33
 * @Email
 */
class App : Application() {


    companion object {
        lateinit var context: Context
        var setPinOpen = true
        var mDevice:BluetoothDevice? = null
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        context = base!!
    }

}