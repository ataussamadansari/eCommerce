package com.example.ecommercetask_2.model

data class OrderItem(
    val imageResId: Int,
    val productName: String,
    val category: String,
    val price: String,
    var quantity: Int = 1
)


