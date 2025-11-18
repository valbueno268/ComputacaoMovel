package com.example.computacaomovel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.computacaomovel.navigation.AppNavHost
import com.example.computacaomovel.ui.theme.ComputacaoMovelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComputacaoMovelTheme {
                AppNavHost()
            }
        }
    }
}