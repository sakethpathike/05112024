package com.example.stomatoassignment.gold.presentation.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import com.example.stomatoassignment.common.utils.shapes.Triangle

@Composable
fun BoxScope.GoldBar(
    modifier: Modifier = Modifier
) {
    Canvas(
        Modifier
            .padding(bottom = 118.5.dp, end = 64.dp)
            .then(modifier)
            .height(10.dp)
            .align(Alignment.BottomEnd)
            .rotate(-180f)
            .width(20.dp)
    ) {
        val paint = Paint().apply {
            this.color = Color(color = 0xFFF4C330)
            this.pathEffect = PathEffect.cornerPathEffect(2f)
        }
        drawIntoCanvas { canvas: Canvas ->
            canvas.drawOutline(Outline.Generic(Triangle.regularTrianglePath(size)), paint = paint)
        }
    }
    Box(
        Modifier
            .padding(bottom = 118.5.dp, end = 64.5.dp)
            .then(modifier)
            .width(15.dp)
            .height(3.dp)
            .align(Alignment.BottomEnd)
            .rotate(-180f)
            .clip(RoundedCornerShape(bottomStart = 25f))
            .background(Color(color = 0xFFD38729))
    )
    Canvas(
        Modifier
            .padding(bottom = 118.5.dp, end = 72.dp)
            .then(modifier)
            .height(10.dp)
            .align(Alignment.BottomEnd)
            .rotate(-180f)
            .width(15.dp)
    ) {
        val paint = Paint().apply {
            this.color = Color(color = 0xFFFDE996)
            this.pathEffect = PathEffect.cornerPathEffect(2f)
        }
        drawIntoCanvas { canvas: Canvas ->
            canvas.drawOutline(Outline.Generic(Triangle.regularTrianglePath(size)), paint = paint)
        }
    }
}