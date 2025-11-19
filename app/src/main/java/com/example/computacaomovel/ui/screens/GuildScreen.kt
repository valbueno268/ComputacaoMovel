package com.example.computacaomovel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.computacaomovel.ui.theme.StarWarsBlack
import com.example.computacaomovel.ui.theme.StarWarsBlue
import com.example.computacaomovel.ui.theme.StarWarsRed
import com.example.computacaomovel.ui.theme.StarWarsWhite
import com.example.computacaomovel.ui.theme.StarWarsYellow

// mock data class temporaria pra lista
data class GuildMember(
    val name: String,
    val captureRank: Int,
    val reportRank: Int
)

@Composable
fun GuildScreen(
    onBack: () -> Unit = {},
    onWorld: () -> Unit = {},
    onProfile: () -> Unit = {},
    onMissionLog: () -> Unit = {}
) {
    val mockMembers = listOf(
        GuildMember("Arkan Vex", 3, 5),
        GuildMember("Mira Talon", 7, 2),
        GuildMember("Jax Rendar", 12, 11)
    )

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
                    text = "Guild",
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
                    .fillMaxSize()
                    .background(StarWarsYellow.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {

                Text(
                    text = "Guild Name",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = StarWarsWhite
                )

                Spacer(Modifier.height(16.dp))

                Text(text = "Guild Rank: #1", color = StarWarsWhite, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "Your Capture Ranking: #5", color = StarWarsWhite, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "Your Report Ranking: #7", color = StarWarsWhite, fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(24.dp))

                Text(
                    text = "Guild Members:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = StarWarsWhite
                )

                Spacer(Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(mockMembers) { member ->
                        GuildMemberCard(member)
                    }
                }
            }
        }
    }
}

@Composable
fun GuildMemberCard(member: GuildMember) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(StarWarsBlue)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = StarWarsWhite,
            modifier = Modifier.size(48.dp)
        )

        Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(text = member.name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = StarWarsWhite)
            Text(text = "Guild Rank (Captures): ${member.captureRank}", color = StarWarsWhite, fontSize = 14.sp)
            Text(text = "Guild Rank (Reports): ${member.reportRank}", color = StarWarsWhite, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuildScreenPreview() {
    GuildScreen()
}
