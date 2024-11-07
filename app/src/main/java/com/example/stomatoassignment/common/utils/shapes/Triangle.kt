package com.example.stomatoassignment.common.utils.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class Triangle : Shape {
    companion object {
        val regularTrianglePath: (size: Size) -> Path = { size ->
            val width = size.width
            val height = size.height

            Path().apply {
                moveTo(0f, 0f)
                lineTo(width, 0f)
                lineTo(width * 0.8f, height)
                lineTo(width * 0.2f, height)
                close()
            }
        }

    }

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(regularTrianglePath(size))
    }
}