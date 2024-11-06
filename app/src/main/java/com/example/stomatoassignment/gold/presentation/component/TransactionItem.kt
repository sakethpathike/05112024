package com.example.stomatoassignment.gold.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stomatoassignment.gold.model.TransactionEntryItem
import com.example.stomatoassignment.gold.utils.TransactionStatus

@Composable
fun TransactionItem(transactionHappenedOn: String, entries: List<TransactionEntryItem>) {
    Text(
        text = transactionHappenedOn,
        modifier = Modifier.padding(start = 15.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold, color = Color.White
    )
    entries.forEach {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 25.dp),
            colors = CardColors(
                containerColor = Color(color = 0xFF241F33),
                contentColor = Color(color = 0xFFC6C5CA),
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = it.transactionType,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = when (it.transactionStatus) {
                                    TransactionStatus.Success -> Icons.Default.CheckCircle
                                    TransactionStatus.Processing -> Icons.Default.Sync
                                }, contentDescription = null, modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "${it.time} • ${it.date}", fontSize = 14.sp
                            )
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.padding(end = 15.dp)
                    ) {
                        Text(
                            text = it.amountPaid,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Text(text = it.weightInGrams.toString().plus(" gms"), fontSize = 14.sp)
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(25.dp))
}