package cn.edu.sjtu.windlll.fashionista


import java.io.Serializable



data class CartItem(
    val name: String,
    var quantity: Int,
    val price: Double,
    val url: String,
    val picture: Int?
): Serializable
// Define the data class for the item that will be added to the cart

// Create the shopping cart class
class shoppingCart : Serializable{

    private val cartItems: MutableList<CartItem> = mutableListOf()

    fun addItemToCart(itemName: String, quantity: Int, price: Double, url: String, picture: Int?) {
        val item = CartItem(itemName, quantity, price, url, picture)
        val existingItem = cartItems.find { it.name == itemName }
        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            cartItems.add(item)
        }
    }

    fun getCartItems(): List<CartItem> {
        return cartItems
    }

    fun deletezeroCartItems() {
        cartItems.removeAll() { it.quantity == 0 }
    }

    fun removeItemFromCart(itemName: String) {
        val existingItem = cartItems.find { it.name == itemName }
        if (existingItem != null) {
            cartItems.remove(existingItem)
        }
    }

    fun getTotal(): Double {
        return cartItems.sumOf { it.price * it.quantity }
    }

    fun clearCart() {
        cartItems.clear()
    }

}
