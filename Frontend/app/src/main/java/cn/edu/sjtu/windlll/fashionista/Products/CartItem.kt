package cn.edu.sjtu.windlll.fashionista.Products

import java.io.Serializable

data class CartItem(
    val name: String,
    var quantity: Int,
    val price: Double,
    val url: String,
    val picture: Int?,
    val category: String
): Serializable


// Define the data class for the item that will be added to the cart