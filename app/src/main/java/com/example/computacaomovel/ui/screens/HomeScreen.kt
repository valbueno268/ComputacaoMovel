package com.example.computacaomovel.ui.screens

// HomeScreen.kt
// UI inspirado no PBF

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.computacaomovel.ui.theme.StarWarsBlack
import com.example.computacaomovel.ui.theme.StarWarsBlue
import com.example.computacaomovel.ui.theme.StarWarsRed
import com.example.computacaomovel.ui.theme.StarWarsYellow


@Composable
fun HomeScreen(
    onBountyBoard: () -> Unit = {},
    onTrackingMap: () -> Unit = {},
    onReportSighting: () -> Unit = {},
    onTranslator: () -> Unit = {},
    onCaptureMode: () -> Unit = {},
    onWorld: () -> Unit = {},
    onProfile: () -> Unit = {},
    onMissionLog: () -> Unit = {},
    onNotifications: () -> Unit = {}
) {
    Scaffold(
        containerColor = StarWarsBlack,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onNotifications) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        Modifier.size(64.dp),
                        tint = StarWarsYellow
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                onWorld = onWorld,
                onProfile = onProfile,
                onMissionLog = onMissionLog
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HomeButton("Bounty Board", onBountyBoard, Modifier.weight(1f))
                HomeButton("Tracking Map", onTrackingMap, Modifier.weight(1f))
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HomeButton("Report Sighting", onReportSighting, Modifier.weight(1f))
                HomeButton("Translator", onTranslator, Modifier.weight(1f))
            }

            Spacer(Modifier.height(16.dp))

            HomeButton(
                text = "Capture Mode",
                onClick = onCaptureMode,
                modifier = Modifier.fillMaxWidth(0.9f)
            )
        }
    }
}

@Composable
fun HomeButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = StarWarsYellow,
        modifier = modifier
            .height(120.dp)
            .clickable { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text, fontSize = 24.sp)
        }
    }
}

@Composable
fun BottomNavigationBar(
    onWorld: () -> Unit,
    onProfile: () -> Unit,
    onMissionLog: () -> Unit
) {
    NavigationBar(
        containerColor = StarWarsBlue
    ) {
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
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = null, tint = StarWarsYellow) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenInteractivePreview() {
    HomeScreen()
}