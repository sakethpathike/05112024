package com.example.stomatoassignment.gold.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stomatoassignment.common.utils.customRememberSavable
import com.example.stomatoassignment.gold.model.TransactionEntry
import com.example.stomatoassignment.gold.model.TransactionEntryItem
import com.example.stomatoassignment.gold.utils.TransactionStatus

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
    ) {
        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color(color = 0xFF1B1539))
                .drawBehind {
                    val gridSpacing = 18f
                    println(size.width)
                    (0..size.width.toInt() step gridSpacing.toInt()).forEach {
                        val bottomX = gridSpacing * (it / 4)
                        val topX = bottomX + (gridSpacing * (4))
                        drawLine(
                            color = Color.White,
                            start = Offset(
                                x = bottomX * 2,
                                y = size.height
                            ),
                            end = Offset(
                                x = topX,
                                y = 0f
                            ),
                            strokeWidth = 1f
                        )
                    }
                    var horizontalY = 0f
                    (0..size.height.toInt() step 10).forEachIndexed { index, int ->
                        horizontalY += int.toFloat()
                        if (horizontalY > size.height) return@forEachIndexed
                        drawLine(
                            color = Color.White,
                            start = Offset(
                                x = 0f,
                                y = horizontalY
                            ),
                            end = Offset(
                                x = size.width,
                                y = horizontalY
                            ),
                            strokeWidth = 0.5f
                        )
                    }
                }) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, top = 25.dp, end = 15.dp)
                ) {
                    Text(text = "24K Gold in Locker", color = Color(color = 0xFFFFD700))
                    Spacer(Modifier.height(20.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "0.828gm", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(
                            Modifier
                                .padding(start = 15.dp, end = 15.dp)
                                .width(1.5.dp)
                                .height(20.dp)
                                .background(Color.White)
                        )
                        Text(
                            text = "₹ 1200",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White.copy(0.75f)
                        )
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
                    icon = Icons.Default.ArrowDropDown,
                    positionOnLeft = false
                )
                CustomFilterButton(
                    text = "Statement",
                    icon = Icons.Default.Download,
                    positionOnLeft = true
                )
                CustomFilterButton(
                    text = "Filters",
                    icon = Icons.Default.FilterAlt,
                    positionOnLeft = true
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
private fun CustomFilterButton(text: String, icon: ImageVector, positionOnLeft: Boolean) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFF302945),
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(Color(color = 0xff241F33))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            Spacer(Modifier.width(5.dp))
            if (positionOnLeft) {
                Icon(imageVector = icon, contentDescription = null, tint = Color(0xffF2F1F3))
                Spacer(Modifier.width(5.dp))
            }
            Text(text = text, color = Color(0xffF2F1F3))
            if (positionOnLeft.not()) {
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