package com.example.computacaomovel.ui.screens

import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import com.example.computacaomovel.ui.theme.StarWarsBlack
import com.example.computacaomovel.ui.theme.StarWarsBlue
import com.example.computacaomovel.ui.theme.StarWarsWhite
import com.example.computacaomovel.ui.theme.StarWarsYellow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.computacaomovel.ui.theme.StarWarsRed

@Composable
fun BountyBoardScreen(
    onBack: () -> Unit = {},
    onWorld: () -> Unit = {},
    onProfile: () -> Unit = {},
    onMissionLog: () -> Unit = {},
    onBountyClick: (String) -> Unit = {}
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
                    text = "Bounty Board",
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

        val mockBountyList = List(12) { index -> "Name #$index" }

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(StarWarsBlack)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(mockBountyList) { name ->
                BountyCard(
                    name = name,
                    onClick = { onBountyClick(name) }
                )
            }
        }
    }
}

@Composable
fun BountyCard(name: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(StarWarsRed.copy(alpha = 0.4f))
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
            Text("Last known coordinates:", color = StarWarsWhite, fontSize = 14.sp)
            Text("40.7128, -74.0060", color = StarWarsWhite, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BountyBoardScreenInteractivePreview() {
    BountyBoardScreen()
}