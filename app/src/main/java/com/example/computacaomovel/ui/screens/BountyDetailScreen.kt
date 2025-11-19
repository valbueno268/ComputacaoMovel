package com.example.computacaomovel.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.computacaomovel.ui.theme.StarWarsBlack
import com.example.computacaomovel.ui.theme.StarWarsBlue
import com.example.computacaomovel.ui.theme.StarWarsWhite
import com.example.computacaomovel.ui.theme.StarWarsYellow

@Composable
fun BountyDetailScreen(
    bountyName: String = "Name",
    onBack: () -> Unit = {},
    onWorld: () -> Unit = {},
    onProfile: () -> Unit = {},
    onMissionLog: () -> Unit = {},
    onOpenMap: () -> Unit = {}
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
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(StarWarsBlack)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .background(StarWarsYellow.copy(alpha = 0.15f))
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = StarWarsWhite,
                        modifier = Modifier.size(48.dp)
                    )
                    Text(
                        text = bountyName,
                        color = StarWarsWhite,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp)
                            .padding(horizontal = 8.dp)
                    )
                }

                Column(
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Last known location:",
                        color = StarWarsWhite.copy(alpha = 0.7f),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "40.7128, -74.0060 (localidade tbm)",
                        color = StarWarsWhite.copy(alpha = 0.7f),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Last seen: (2025-09-09 08:13:13)",
                        color = StarWarsWhite.copy(alpha = 0.7f),
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Last report by: @username",
                        color = StarWarsWhite.copy(alpha = 0.7f),
                        fontSize = 20.sp
                    )
                }

                Row(
                    modifier = Modifier.padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(120.dp, 130.dp)
                            .rotate(2f)
                            .background(StarWarsWhite)
                            .padding(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFFE8F4F8))
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(40.dp)
                                    .align(Alignment.BottomCenter)
                                    .background(Color(0xFF7CB342))
                            )
                        }
                    }
                }

                Button(
                    onClick = onOpenMap,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = StarWarsYellow.copy(alpha = 0.25f)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = StarWarsWhite,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Open in Map Tracker",
                        color = StarWarsWhite,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BountyDetailScreenPreview() {
    BountyDetailScreen(bountyName = "Name")
}