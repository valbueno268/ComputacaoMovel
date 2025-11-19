package com.example.computacaomovel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.computacaomovel.ui.theme.StarWarsBlack
import com.example.computacaomovel.ui.theme.StarWarsBlue
import com.example.computacaomovel.ui.theme.StarWarsRed
import com.example.computacaomovel.ui.theme.StarWarsWhite
import com.example.computacaomovel.ui.theme.StarWarsYellow

@Composable
fun MissionLogScreen(
    onBack: () -> Unit = {},
    onWorld: () -> Unit = {},
    onProfile: () -> Unit = {},
    onMissionLog: () -> Unit = {},
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
                    text = "Mission Log",
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

        val mockMissionList = List(12) { index -> "Name #$index" }

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(StarWarsBlack)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(mockMissionList) { name ->
                MissionCard(
                    name = name,
                )
            }
        }
    }
}

@Composable
fun MissionCard(name: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(StarWarsRed.copy(alpha = 0.35f))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = StarWarsWhite,
            modifier = Modifier.size(48.dp)
        )

        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(name, color = StarWarsWhite, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Capture date:", color = StarWarsWhite.copy(alpha = 0.7f), fontSize = 14.sp)
            Text("17/10/2025, 14:15", color = StarWarsWhite.copy(alpha = 0.7f), fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MissionLogScreenInteractivePreview() {
    MissionLogScreen()
}
