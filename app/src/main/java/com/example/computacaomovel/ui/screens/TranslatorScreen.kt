// TranslatorScreen.kt - Translator screen with Star Wars styling
package com.example.computacaomovel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.computacaomovel.ui.theme.StarWarsBlack
import com.example.computacaomovel.ui.theme.StarWarsBlue
import com.example.computacaomovel.ui.theme.StarWarsWhite
import com.example.computacaomovel.ui.theme.StarWarsYellow

@Composable
fun TranslatorScreen(
    onBack: () -> Unit = {},
    onWorld: () -> Unit = {},
    onProfile: () -> Unit = {},
    onMissionLog: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(StarWarsYellow)
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = StarWarsBlack
                    )
                }
                Text(
                    text = "Translator",
                    color = StarWarsBlack,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        },
        bottomBar = {
            NavigationBar(containerColor = StarWarsBlue) {
                NavigationBarItem(
                    selected = false,
                    onClick = onWorld,
                    label = { Text("World", color = StarWarsYellow) },
                    icon = { Icon(Icons.Default.Info, contentDescription = null, tint = StarWarsYellow) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = onProfile,
                    label = { Text("Profile", color = StarWarsYellow) },
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = null, tint = StarWarsYellow) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = onMissionLog,
                    label = { Text("Mission Log", color = StarWarsYellow) },
                    icon = { Icon(Icons.Default.List, contentDescription = null, tint = StarWarsYellow) }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(StarWarsBlack),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Translation output area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(StarWarsWhite.copy(alpha = 0.3f))
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "",
                    color = StarWarsBlack,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp
                )
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { /* TODO: Implement voice recording */ },
                    modifier = Modifier.size(80.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Record",
                        tint = StarWarsWhite,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TranslatorScreenPreview() {
    TranslatorScreen()
}