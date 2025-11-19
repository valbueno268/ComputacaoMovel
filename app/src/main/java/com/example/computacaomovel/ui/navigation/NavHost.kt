package com.example.computacaomovel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.computacaomovel.ui.screens.HomeScreen
import com.example.computacaomovel.ui.screens.BountyBoardScreen
import com.example.computacaomovel.ui.screens.BountyDetailScreen
import com.example.computacaomovel.ui.screens.CaptureModeScreen
import com.example.computacaomovel.ui.screens.GuildScreen
import com.example.computacaomovel.ui.screens.MissionLogScreen
import com.example.computacaomovel.ui.screens.ProfileScreen
import com.example.computacaomovel.ui.screens.ReportSightingScreen
import com.example.computacaomovel.ui.screens.TrackingMapScreen
import com.example.computacaomovel.ui.screens.TranslatorScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                onBountyBoard = { navController.navigate("bountyBoard") },
                onTrackingMap = { navController.navigate("trackingMap") },
                onReportSighting = {  navController.navigate("reportSighting") },
                onTranslator = { navController.navigate("translator") },
                onCaptureMode = { navController.navigate("captureMode") },
                onWorld = { /* TODO */ },
                onProfile = { navController.navigate("profile") },
                onMissionLog = { navController.navigate("missionLog") },
                onNotifications = { /* TODO */ }
            )
        }

        composable("bountyBoard") {
            BountyBoardScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { navController.navigate("missionLog") },
                onBountyClick = { bountyName ->
                    navController.navigate("bountyDetail/$bountyName")
                }
            )
        }

        composable("bountyDetail/{bountyName}") { backStackEntry ->
            val bountyName = backStackEntry.arguments?.getString("bountyName") ?: "Unknown"
            BountyDetailScreen(
                bountyName = bountyName,
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { navController.navigate("missionLog") },
                onOpenMap = { navController.navigate("trackingMap") }
            )
        }

        composable("trackingMap") {
            TrackingMapScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = {  navController.navigate("missionLog") }
            )
        }

        composable("reportSighting") {
            ReportSightingScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = {  navController.navigate("missionLog") }
            )
        }

        composable("translator") {
            TranslatorScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { navController.navigate("missionLog") }
            )
        }

        composable("captureMode") {
            CaptureModeScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { navController.navigate("missionLog") }
            )
        }

        composable("missionLog") {
            MissionLogScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { navController.navigate("missionLog") },
            )
        }

        composable("guild") {
            GuildScreen (
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { navController.navigate("missionLog") },
            )
        }

        composable("profile") {
            ProfileScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { navController.navigate("profile") },
                onGuild = { navController.navigate("guild") }
            )
        }
    }
}
