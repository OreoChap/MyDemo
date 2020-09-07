package com.arron.mydemo

import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.arron.mydemo.ClsUtils.setPin


class BluetoothConnectActivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent) {
        if ("android.bluetooth.device.action.PAIRING_REQUEST" == intent.action) {
            val mBluetoothDevice =
                intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
            try {
                //(三星)4.3版本测试手机还是会弹出用户交互页面(闪一下)，如果不注释掉下面这句页面不会取消但可以配对成功。(中兴，魅族4(Flyme 6))5.1版本手机两中情况下都正常
                //ClsUtils.setPairingConfirmation(mBluetoothDevice.getClass(), mBluetoothDevice, true);

                //3.调用setPin方法进行配对...
                if (App.setPinOpen) {
                    abortBroadcast() //如果没有将广播终止，则会出现一个一闪而过的配对框。
                    val ret =
                        setPin(mBluetoothDevice.javaClass, mBluetoothDevice, "123456")
                }
            } catch (e: Exception) {
                Log.e("XYZ", "onReceive——Exception:\n" + e)
            }
        }
    }
}