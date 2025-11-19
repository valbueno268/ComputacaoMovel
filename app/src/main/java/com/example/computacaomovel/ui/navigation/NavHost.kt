package com.example.computacaomovel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.computacaomovel.ui.screens.HomeScreen
import com.example.computacaomovel.ui.screens.BountyBoardScreen
import com.example.computacaomovel.ui.screens.BountyDetailScreen
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
                onTrackingMap = { /* TODO */ },
                onReportSighting = { /* TODO */ },
                onTranslator = { navController.navigate("translator") },
                onCaptureMode = { /* TODO */ },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { /* TODO */ },
                onNotifications = { /* TODO */ }
            )
        }

        composable("bountyBoard") {
            BountyBoardScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { /* TODO */ },
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
                onMissionLog = { /* TODO */ },
                onOpenMap = { /* TODO */ }
            )
        }

        composable("translator") {
            TranslatorScreen(
                onBack = { navController.popBackStack() },
                onWorld = { /* TODO */ },
                onProfile = { /* TODO */ },
                onMissionLog = { /* TODO */ }
            )
        }
    }
}
