package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = CyberGreen,
    onPrimary = TechBackground,
    primaryContainer = TechSurfaceVariant,
    onPrimaryContainer = CyberGreen,
    secondary = CyberCyan,
    onSecondary = TechBackground,
    secondaryContainer = TechSurfaceVariant,
    onSecondaryContainer = CyberCyan,
    tertiary = CyberBlue,
    onTertiary = TextPrimary,
    background = TechBackground,
    onBackground = TextPrimary,
    surface = TechSurface,
    onSurface = TextPrimary,
    surfaceVariant = TechSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = TechCardBorder,
    outlineVariant = TechDivider
)

@Composable
fun TwhOrgTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
