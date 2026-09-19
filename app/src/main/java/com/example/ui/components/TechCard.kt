package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui.theme.TechCardBorder

@Composable
fun TechCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    borderColor: Color = TechCardBorder,
    borderWidth: Dp = 1.dp,
    contentPadding: Dp = 16.dp,
    accentGlow: Color? = null,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    val bgBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF131F37).copy(alpha = 0.85f),
            Color(0xFF0D1527).copy(alpha = 0.95f)
        )
    )

    val border = if (accentGlow != null) {
        BorderStroke(
            borderWidth,
            Brush.linearGradient(
                colors = listOf(
                    accentGlow.copy(alpha = 0.6f),
                    borderColor.copy(alpha = 0.4f),
                    Color(0xFF13223A)
                )
            )
        )
    } else {
        BorderStroke(borderWidth, borderColor)
    }

    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            border = border,
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(shape)
                    .background(bgBrush)
                    .padding(contentPadding)
            ) {
                Column {
                    content()
                }
            }
        }
    } else {
        Card(
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            border = border,
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(shape)
                    .background(bgBrush)
                    .padding(contentPadding)
            ) {
                Column {
                    content()
                }
            }
        }
    }
}
