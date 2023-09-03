package com.example.assigmentproject.data

data class ProductDetails(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)