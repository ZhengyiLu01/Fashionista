package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.windlll.fashionista.RecyclerView.ShopItemAdapter
import java.io.Serializable

class ShopActivity : AppCompatActivity() {
    private val shop = shop()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shop)
        shop.addItemToShop(1,"Item 1", 10.0 , "google.com",4.0,null)
        shop.addItemToShop(2,"Item 2", 20.0 , "naver.com",4.6,null)
        shop.addItemToShop(3,"Item 3", 30.0 , "youtube.com",4.2,null)

        val recyclerView: RecyclerView = findViewById(R.id.shop_recycler_view)
        val shopItemAdapter = ShopItemAdapter(shop.getShopItems())
        recyclerView.adapter = shopItemAdapter

        val backtohome: Button = findViewById(R.id.Backtohome)
        backtohome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("shop", shop as Serializable)
            startActivity(intent)
        }
    }
}