package cn.edu.sjtu.windlll.fashionista


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.windlll.fashionista.RecyclerView.CartItemAdapter


import java.io.Serializable



class ShoppingCartActivity : AppCompatActivity() {
    private val shoppingCart =shoppingCart()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_cart)
        shoppingCart.addItemToCart("Item 1", 2, 10.0 , "google.com",null)
        shoppingCart.addItemToCart("Item 2", 1,20.0 , "naver.com",null)
        shoppingCart.addItemToCart("Item 3", 3,30.0 , "youtube.com",null)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val cartItemAdapter = CartItemAdapter(shoppingCart.getCartItems())
        recyclerView.adapter = cartItemAdapter

        val openReceiptButton: Button = findViewById(R.id.open_receipt_button)
        openReceiptButton.setOnClickListener {
            val intent = Intent(this, ReceiptActivity::class.java)
            shoppingCart.deletezeroCartItems()
            intent.putExtra("shoppingCart", shoppingCart as Serializable)
            startActivity(intent)
        }

        val backtohome: Button = findViewById(R.id.Backtohome)
        backtohome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}