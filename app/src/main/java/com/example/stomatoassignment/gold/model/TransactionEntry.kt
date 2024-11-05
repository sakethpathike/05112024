package com.example.stomatoassignment.gold.model

import com.example.stomatoassignment.gold.utils.TransactionStatus
import kotlinx.serialization.Serializable

@Serializable
data class TransactionEntry(
    val transactionHappenedOn: String,
    val transactionEntryItems: List<TransactionEntryItem>
)

@Serializable
data class TransactionEntryItem(
    val transactionType:String,
    val transactionStatus: TransactionStatus,
    val time: String,
    val date: String,
    val amountPaid: String,
    val weightInGrams: Float
)
