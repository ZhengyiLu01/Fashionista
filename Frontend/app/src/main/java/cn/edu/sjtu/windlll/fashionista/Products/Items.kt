package cn.edu.sjtu.windlll.fashionista.Products

import java.io.Serializable

data class Items(
    val id: Int,
    val name: String,
    val price: Double,
    val url: String,
    val rating: Double,
    val picture: Int?,
    var ifincart: Int
): Serializable