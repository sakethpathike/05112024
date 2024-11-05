package com.example.stomatoassignment.gold.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(start = 15.dp, top = 25.dp, end = 15.dp)
            ) {
                Text(text = "24K Gold in Locker", color = MaterialTheme.colorScheme.primary)
                Spacer(Modifier.height(20.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "0.828gm", fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(
                        Modifier
                            .padding(start = 15.dp, end = 15.dp)
                            .width(1.5.dp)
                            .height(20.dp)
                            .background(MaterialTheme.colorScheme.onPrimaryContainer)
                    )
                    Text(
                        text = "₹ 1200",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = LocalContentColor.current.copy(0.75f)
                    )
                }
                Spacer(Modifier.height(30.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
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
    Button(
        onClick = {},
        colors = ButtonColors(
            containerColor = Color(color = 0xff241F33),
            contentColor = Color(0xffF2F1F3),
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.border(
            width = 2.dp,
            color = Color(0xFF302945),
            shape = RoundedCornerShape(12.dp)
        )
    ) {
        if (positionOnLeft) {
            Icon(imageVector = icon, contentDescription = null)
            Spacer(Modifier.width(5.dp))
        }
        Text(text = text)
        if (positionOnLeft.not()) {
            Spacer(Modifier.width(5.dp))
            Icon(imageVector = icon, contentDescription = null)
        }
    }
}