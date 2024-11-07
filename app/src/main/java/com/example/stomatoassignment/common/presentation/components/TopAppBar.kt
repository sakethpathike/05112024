package com.example.stomatoassignment.common.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Headset
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(color = 0xFF36156E)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .padding(start = 15.dp)
                .size(45.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.White.copy(0.35f),
                            Color(color = 0xFF3E3056),
                            Color(color = 0xFF3E3056),
                        )
                    )
                )
                .border(width = 1.dp, color = Color.White.copy(0.25f), shape = CircleShape)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "VR",
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {}, modifier = Modifier
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                Color.White.copy(0.35f),
                                Color(color = 0xFF3E3056),
                                Color(color = 0xFF3E3056),
                            )
                        )
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Headset,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
            Spacer(Modifier.width(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(15.dp)
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.White.copy(0.25f),
                                Color(color = 0xFF3E3056),
                                Color(color = 0xFF3E3056),
                            )
                        )
                    )
            ) {
                Box {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(end = 8.dp, top = 8.dp)
                            .border(width = 2.5.dp, shape = CircleShape, color = Color(0xFF38324D))
                            .clip(CircleShape)
                            .size(18.dp)
                            .background(Color(color = 0xFFDD8091))
                            .align(Alignment.TopEnd)
                    ) {
                        Text(
                            text = "2",
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(top = 2.dp, start = 6.dp)
                        )
                    }
                }
                Spacer(
                    Modifier
                        .padding(start = 5.dp, end = 5.dp)
                        .width(1.5.dp)
                        .height(10.dp)
                        .background(Color.White)
                )
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.CardGiftcard,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
        }
    }
}