package org.chevalierlab.kashier.history.domain

data class TransactionHistory(
    val totalPrice: Double,
    val totalItems: Int,
    val date: String
)
