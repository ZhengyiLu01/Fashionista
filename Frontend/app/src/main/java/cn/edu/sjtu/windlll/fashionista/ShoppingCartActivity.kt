package cn.edu.sjtu.windlll.fashionista


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.math_is_fun12.testing123.RecyclerView.CartItemAdapter

import java.io.Serializable



// Create the shopping cart class
class ShoppingCartActivity : AppCompatActivity() {
    private val shoppingCart = shoppingCart()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_cart)
        shoppingCart.addItemToCart("Item 1", 2, 10.0 , "google.com",null)
        shoppingCart.addItemToCart("Item 2", 1,20.0 , "naver.com",null)
        shoppingCart.addItemToCart("Item 1", 3,10.0 , "google.com",null) // Increasing quantity of Item 1
        shoppingCart.addItemToCart("Item 3", 3,30.0 , "youtube.com",null)
        // Add items to the cart here...

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = CartItemAdapter(shoppingCart.getCartItems())
        val openReceiptButton: Button = findViewById(R.id.open_receipt_button)
        openReceiptButton.setOnClickListener {
            val intent = Intent(this, ReceiptActivity::class.java)
            intent.putExtra("cartItems", shoppingCart.getCartItems().toTypedArray())

            startActivity(intent)
        }
    }
}
