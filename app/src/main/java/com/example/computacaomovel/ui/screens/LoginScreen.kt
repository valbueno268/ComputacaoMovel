package com.example.computacaomovel.ui.screens

// LoginScreen.kt
// Ecrã de login

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.computacaomovel.ui.theme.StarWarsBlack
import com.example.computacaomovel.ui.theme.StarWarsWhite
import com.example.computacaomovel.ui.theme.StarWarsYellow

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onGoogleLoginClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(StarWarsBlack),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = "Login", style = MaterialTheme.typography.headlineLarge , color = StarWarsYellow)


            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = StarWarsYellow) },
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = StarWarsYellow) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { onLoginClick(email, password) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = StarWarsYellow)
            ) {
                Text("Entrar", color = StarWarsBlack)
            }

            TextButton(onClick = onGoogleLoginClick) {
                Text("Entrar com Google", color = StarWarsYellow)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenInteractivePreview() {
    LoginScreen()
}

