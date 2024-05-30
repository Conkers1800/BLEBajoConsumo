package com.conkers.blebajoconsumo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.conkers.blebajoconsumo.Conectividad.BleService
import com.conkers.blebajoconsumo.ui.theme.BLEBajoconsumoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BLEBajoconsumoTheme {
                BleScreen()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun BleScreen() {
    var bleStatus by remember { mutableStateOf("BLE Service Stopped") }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = bleStatus, style = MaterialTheme.typography.displayMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            context.startService(Intent(context, BleService::class.java))
            bleStatus = "BLE Service Started"
        }) {
            Text("Start BLE Service")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            context.stopService(Intent(context, BleService::class.java))
            bleStatus = "BLE Service Stopped"
        }) {
            Text("Stop BLE Service")
        }
    }
}

