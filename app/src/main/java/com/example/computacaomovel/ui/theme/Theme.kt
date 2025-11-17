package com.example.computacaomovel.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.computacaomovel.ui.theme.StarWarsBlack



private val DarkColorScheme = darkColorScheme(
    primary = StarWarsYellow,
    secondary = StarWarsBlue,
    background = StarWarsBlack,
    surface = StarWarsBlack,
    onPrimary = StarWarsBlack,
    onSecondary = StarWarsBlack,
    onBackground = StarWarsWhite,
    onSurface = StarWarsWhite
)

private val LightColorScheme = lightColorScheme(
    primary = StarWarsYellow,
    secondary = StarWarsBlue,
    background = StarWarsWhite,
    surface = StarWarsWhite,
    onPrimary = StarWarsBlack,
    onSecondary = StarWarsBlack,
    onBackground = StarWarsBlack,
    onSurface = StarWarsBlack

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun ComputacaoMovelTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}