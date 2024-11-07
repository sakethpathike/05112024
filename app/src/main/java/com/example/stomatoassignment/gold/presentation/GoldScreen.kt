package com.example.stomatoassignment.gold.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stomatoassignment.common.utils.customRememberSavable
import com.example.stomatoassignment.common.utils.shapes.Triangle
import com.example.stomatoassignment.gold.model.TransactionEntry
import com.example.stomatoassignment.gold.model.TransactionEntryItem
import com.example.stomatoassignment.gold.presentation.component.GoldBar
import com.example.stomatoassignment.gold.presentation.component.TransactionItem
import com.example.stomatoassignment.gold.utils.TransactionStatus

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun GoldScreen() {
    val transactionsData = customRememberSavable {
        listOf(
            TransactionEntry(
                transactionHappenedOn = "Today",
                transactionEntryItems = listOf(
                    TransactionEntryItem(
                        transactionType = "Manual Buy",
                        transactionStatus = TransactionStatus.Success,
                        time = "7:00 PM",
                        date = "Sep 18",
                        amountPaid = "₹20",
                        weightInGrams = 0.0045f
                    ),
                    TransactionEntryItem(
                        transactionType = "Manual Buy",
                        transactionStatus = TransactionStatus.Processing,
                        time = "7:00 PM",
                        date = "Sep 18",
                        amountPaid = "₹200",
                        weightInGrams = 0.0045f
                    )
                )
            ),
            TransactionEntry(
                transactionHappenedOn = "Yesterday",
                transactionEntryItems = listOf(
                    TransactionEntryItem(
                        transactionType = "Manual Buy",
                        transactionStatus = TransactionStatus.Success,
                        time = "7:00 PM",
                        date = "Sep 18",
                        amountPaid = "₹649",
                        weightInGrams = 0.0045f
                    ),
                    TransactionEntryItem(
                        transactionType = "Manual Buy",
                        transactionStatus = TransactionStatus.Processing,
                        time = "7:00 PM",
                        date = "Sep 18",
                        amountPaid = "₹20",
                        weightInGrams = 0.0045f
                    )
                )
            ),
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(color = 0xff1D1829))
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color(color = 0xFF1B1539))
                    .drawBehind {
                        val gridSpacing = 24f
                        (0..size.width.toInt() step gridSpacing.toInt()).forEach {
                            val bottomX = gridSpacing * (it / 4)
                            val topX = bottomX + (gridSpacing * (4))

                            val lineMidPointX = (bottomX + topX) / 2

                            drawLine(
                                brush = Brush.linearGradient(
                                    listOf(
                                        Color.White.copy(0.75f), Color(0xFF352359)
                                    )
                                ), start = Offset(
                                    x = if (size.width / 2 > lineMidPointX) bottomX * 1.4.toFloat() else bottomX * 1.5.toFloat(),
                                    y = size.height
                                ), end = Offset(x = topX, y = 0f), strokeWidth = 0.75f
                            )
                        }

                        // horizontal part of the grid
                        var horizontalY = 0f
                        (0..size.height.toInt() step 10).forEachIndexed { index, int ->
                            horizontalY += int.toFloat()
                            if (horizontalY > size.height) return@forEachIndexed
                            drawLine(
                                brush = Brush.linearGradient(
                                    listOf(
                                        Color.White.copy(0.75f), Color(0xFF352359)
                                    )
                                ), start = Offset(
                                    x = 0f, y = horizontalY
                                ), end = Offset(
                                    x = size.width, y = horizontalY
                                ), strokeWidth = 0.25f
                            )
                        }

                        drawOval(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color.White,
                                    Color.White,
                                    Color(0xFF481E7E),
                                    Color(0xFF3A1967),
                                )
                            ),
                            size = Size(210f, 28f),
                            topLeft = Offset(x = size.width - 300f, y = size.height - 215)
                        )
                        drawRoundRect(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color.White,
                                    Color.White,
                                    Color(0xFF481E7E),
                                    Color(0xFF3A1967),
                                )
                            ),
                            size = Size(210f, 100f),
                            topLeft = Offset(x = size.width - 300f, y = size.height - 200)
                        )
                    }) {
                val boxHeight = 75.dp
                Box(
                    Modifier
                        .padding(bottom = 115.dp, end = 55.dp)
                        .size(width = 85.dp, height = boxHeight)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(Color(0xFF248AE0))
                        .align(Alignment.BottomEnd)
                ) {
                    Box(
                        Modifier
                            .fillMaxHeight()
                            .width(width = 60.dp)
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .background(Color(0xFF1C445F))
                            .border(
                                width = 3.5.dp,
                                color = Color(0xFF79B4E2),
                                shape = RoundedCornerShape(10.dp)
                            )
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(bottom = 85.dp)
                        .align(Alignment.BottomEnd)
                        .height(140.dp)
                        .width(100.dp)
                        .rotate(90f)
                        .clip(Triangle())
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFFFFD700).copy(0.45f),
                                    Color.Transparent,
                                    Color.White.copy(0.45f)
                                )
                            )
                        )
                )

                // leaf right:
                GoldBar()
                // leaf left:
                GoldBar(modifier = Modifier.padding(end = 30.dp))

                // leaf-1 right:
                GoldBar(modifier = Modifier.padding(bottom = 10.dp))
                // leaf-2 left
                GoldBar(modifier = Modifier.padding(end = 30.dp, bottom = 10.dp))

                // leaf-3
                GoldBar(modifier = Modifier.padding(bottom = 20.dp, end = 8.dp))

                // leaf-4
                GoldBar(modifier = Modifier.padding(end = 25.dp, bottom = 30.dp))

                Box(
                    Modifier
                        .padding(bottom = 115.dp, end = 120.dp)
                        .size(width = 25.dp, height = boxHeight)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(Color(0xFF003366))
                        .align(Alignment.BottomEnd)
                )
                Box(
                    Modifier
                        .padding(bottom = 130.dp, end = 118.dp)
                        .size(width = 35.dp, height = 15.dp)
                        .clip(
                            RoundedCornerShape(25.dp)
                        )
                        .background(Color(0xFFCCE5FD))
                        .align(Alignment.BottomEnd)
                )

                Box(
                    Modifier
                        .padding(bottom = 160.dp, end = 118.dp)
                        .size(width = 35.dp, height = 15.dp)
                        .clip(
                            RoundedCornerShape(25.dp)
                        )
                        .background(Color(0xFFCCE5FD))
                        .align(Alignment.BottomEnd)
                )

                Box(
                    Modifier
                        .padding(bottom = 115.dp, end = 130.dp)
                        .size(width = 45.dp, height = boxHeight)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(Color(0xFF004C99))
                        .align(Alignment.BottomEnd)
                ) {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 6.dp, end = 6.dp, top = 11.dp, bottom = 12.dp)
                            .clip(
                                RoundedCornerShape(5.dp)
                            )
                            .background(
                                Color(color = 0xFF0080FF)
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .height(20.dp)
                                .width(10.dp)
                                .clip(RoundedCornerShape(17.5.dp))
                                .background(
                                    Color(color = 0xFFCCE6FF)
                                )
                                .align(Alignment.Center)
                        )

                        Box(
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .height(15.dp)
                                .width(7.5.dp)
                                .clip(RoundedCornerShape(17.5.dp))
                                .background(
                                    Color(color = 0xFF004C99)
                                )
                                .align(Alignment.Center)
                        )

                        Box(
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .height(15.dp)
                                .width(7.5.dp)
                                .clip(RoundedCornerShape(17.5.dp))
                                .background(
                                    Color(color = 0xFFCCE6FF)
                                )
                                .align(Alignment.Center)
                        )

                        //  strokes:
                        Box(
                            modifier = Modifier
                                .rotate(25f)
                                .padding(start = 5.dp, bottom = 5.dp)
                                .height(12.dp)
                                .width(3.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(
                                    Color(color = 0xFF66B2FF)
                                )
                                .align(Alignment.BottomStart)
                        )
                        Box(
                            modifier = Modifier
                                .rotate(32f)
                                .padding(end = 5.dp, top = 5.dp)
                                .height(14.dp)
                                .width(3.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(
                                    Color(color = 0xFF66B2FF)
                                )
                                .align(Alignment.TopEnd)
                        )
                        Box(
                            modifier = Modifier
                                .rotate(-30f)
                                .padding(end = 5.dp, bottom = 5.dp)
                                .height(14.dp)
                                .width(3.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(
                                    Color(color = 0xFF66B2FF)
                                )
                                .align(Alignment.BottomEnd)
                        )
                        Box(
                            modifier = Modifier
                                .rotate(-25f)
                                .padding(start = 5.dp, top = 5.dp)
                                .height(12.dp)
                                .width(3.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(
                                    Color(color = 0xFF66B2FF)
                                )
                                .align(Alignment.TopStart)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 25.dp, end = 15.dp)
                ) {
                    Text(text = "24K Gold in Locker", color = Color(color = 0xFFFFD700))
                    Spacer(Modifier.height(20.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "0.828gm",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(
                            Modifier
                                .padding(start = 15.dp, end = 15.dp)
                                .width(1.5.dp)
                                .height(20.dp)
                                .background(Color.White)
                        )/*  Text(
                              text = "₹ 1200",
                              fontSize = 28.sp,
                              fontWeight = FontWeight.SemiBold,
                              color = Color.White.copy(0.75f)
                          )*/
                    }
                    Spacer(Modifier.height(30.dp))
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp, start = 15.dp, end = 15.dp, top = 15.dp),
                        colors = ButtonColors(
                            containerColor = Color(color = 0xFF5A21A3),
                            contentColor = Color(color = 0xFFFAF9FC),
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Color.Transparent,
                        )
                    ) {
                        Text(
                            text = "Save Manually",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
        item {
            Row(
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 40.dp)
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Spacer(Modifier)
                CustomFilterButton(
                    text = "Status",
                    icon = Icons.Default.ArrowDropDown, iconPositionOnLeft = false
                )
                CustomFilterButton(
                    text = "Statement",
                    icon = Icons.Default.Download, iconPositionOnLeft = true
                )
                CustomFilterButton(
                    text = "Filters",
                    icon = Icons.Default.FilterAlt, iconPositionOnLeft = true
                )
            }
        }
        items(transactionsData) {
            TransactionItem(
                transactionHappenedOn = it.transactionHappenedOn,
                entries = it.transactionEntryItems
            )
        }
    }
}

@Composable
private fun CustomFilterButton(text: String, icon: ImageVector, iconPositionOnLeft: Boolean) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp, color = Color(0xFF302945), shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(Color(color = 0xff241F33))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            Spacer(Modifier.width(5.dp))
            if (iconPositionOnLeft) {
                Icon(imageVector = icon, contentDescription = null, tint = Color(0xffF2F1F3))
                Spacer(Modifier.width(5.dp))
            }
            Text(text = text, color = Color(0xffF2F1F3))
            if (iconPositionOnLeft.not()) {
                Spacer(Modifier.width(5.dp))
                Icon(
                    imageVector = icon, contentDescription = null,
                    tint = Color(0xffF2F1F3)
                )
            }
            Spacer(Modifier.width(5.dp))
        }
    }
}