package com.example.stomatoassignment.gold.presentation

import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    LazyColumn(modifier = Modifier.fillMaxSize()) {
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
                        .padding(20.dp)
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
                Button(onClick = {}, shape = RoundedCornerShape(12.dp)) {
                    Text(text = "Status")
                    Spacer(Modifier.width(5.dp))
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
                Button(onClick = {}, shape = RoundedCornerShape(12.dp)) {
                    Text(text = "Status")
                    Spacer(Modifier.width(5.dp))
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
                Button(onClick = {}, shape = RoundedCornerShape(12.dp)) {
                    Text(text = "Status")
                    Spacer(Modifier.width(5.dp))
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
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