package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.ui.theme.CyberCyan
import com.example.ui.theme.CyberGreen
import com.example.ui.theme.TechBackground

@Composable
fun TechBackgroundWrapper(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        // Deep canvas background with subtle circuit traces and glow nodes
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Radial background gradient
            drawRect(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF0F1B33),
                        Color(0xFF0A1224),
                        TechBackground
                    ),
                    center = Offset(size.width * 0.5f, size.height * 0.2f),
                    radius = size.width * 1.2f
                )
            )

            val strokeWidth = 1f
            val gridColor = Color(0x0C00E5FF)
            val step = 48f

            // Faint circuit grid lines
            var x = 0f
            while (x < size.width) {
                drawLine(
                    color = gridColor,
                    start = Offset(x, 0f),
                    end = Offset(x, size.height),
                    strokeWidth = strokeWidth
                )
                x += step
            }

            var y = 0f
            while (y < size.height) {
                drawLine(
                    color = gridColor,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
                y += step
            }

            // Tech circuit trace top right
            val path1 = Path().apply {
                moveTo(size.width * 0.7f, 0f)
                lineTo(size.width * 0.7f, 120f)
                lineTo(size.width * 0.85f, 180f)
                lineTo(size.width, 180f)
            }
            drawPath(
                path = path1,
                color = Color(0x2000E5FF),
                style = Stroke(width = 2f)
            )
            drawCircle(
                color = CyberCyan.copy(alpha = 0.4f),
                radius = 4f,
                center = Offset(size.width * 0.85f, 180f)
            )

            // Tech circuit trace bottom left
            val path2 = Path().apply {
                moveTo(0f, size.height * 0.75f)
                lineTo(size.width * 0.2f, size.height * 0.75f)
                lineTo(size.width * 0.35f, size.height * 0.85f)
                lineTo(size.width * 0.35f, size.height)
            }
            drawPath(
                path = path2,
                color = Color(0x2000E676),
                style = Stroke(width = 2f)
            )
            drawCircle(
                color = CyberGreen.copy(alpha = 0.4f),
                radius = 4f,
                center = Offset(size.width * 0.2f, size.height * 0.75f)
            )
        }

        content()
    }
}
