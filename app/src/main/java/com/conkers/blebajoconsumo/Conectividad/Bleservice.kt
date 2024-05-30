package com.conkers.blebajoconsumo.Conectividad

import android.app.Service
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class BleService : Service() {

    private lateinit var bluetoothAdapter: BluetoothAdapter

    override fun onCreate() {
        super.onCreate()
        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter

        if (bluetoothAdapter == null) {
            Log.e("BleService", "Bluetooth not supported on this device")
            stopSelf()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startBleScan()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        stopBleScan()
    }

    private fun startBleScan() {
        if (!bluetoothAdapter.isEnabled) {
            // Aquí puedes notificar al usuario que habilite Bluetooth manualmente
            Toast.makeText(this, "Please enable Bluetooth", Toast.LENGTH_SHORT).show()
        } else {
            Log.d("BleService", "BLE scan started")
            // Iniciar el escaneo BLE
        }
    }

    private fun stopBleScan() {
        Log.d("BleService", "BLE scan stopped")
        // Detener el escaneo BLE
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
