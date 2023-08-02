package cn.edu.sjtu.windlll.fashionista

import cn.edu.sjtu.windlll.fashionista.Products.CartItem
import cn.edu.sjtu.windlll.fashionista.Products.Items
import java.io.Serializable

class shop : Serializable {

    private val ShopItems: MutableList<Items> = mutableListOf()

    var size = 0;

    fun addItemToShop(Id: Int, itemName: String, price: Double, url: String, Rating: Double, picture: Int?) {
        val item = Items(Id, itemName, price, url, Rating, picture, 0)
        val existingItem = ShopItems.find { it.name == itemName }
        if (existingItem == null) {
            ShopItems.add(item)
            size++
        }
    }
    fun getShopItems(): List<Items> {
        return ShopItems
    }

    fun getCartItems(): List<CartItem> {
        val shoppingCart = shoppingCart()
        for (i in 0 until size) {
            if (ShopItems[i].ifincart == 1){
                shoppingCart.addItemToCart(
                    ShopItems[i].name,
                    1,
                    ShopItems[i].price,
                    ShopItems[i].url,
                    ShopItems[i].picture
                )
            }
        }
        return  shoppingCart.getCartItems()
    }

    fun removeItemFromShop(itemName: String) {
        val existingItem = ShopItems.find { it.name == itemName }
        if (existingItem != null) {
           ShopItems.remove(existingItem)
        }
    }

}