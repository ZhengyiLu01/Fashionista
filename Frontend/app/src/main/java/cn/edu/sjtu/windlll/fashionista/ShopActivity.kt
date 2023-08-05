package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.windlll.fashionista.Products.CartItem
import cn.edu.sjtu.windlll.fashionista.Products.Items
import cn.edu.sjtu.windlll.fashionista.RecyclerView.ShopItemAdapter
import java.io.Serializable

class ShopActivity : AppCompatActivity() {
    private val shop = shop()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shop)
        shop.addItemToShop(1,"Item 1", 10.0 , "google.com",4.0,null, "shorts")
        shop.addItemToShop(2,"Item 2", 20.0 , "adidas.com",4.6,null, "shirts")
        shop.addItemToShop(3,"Item 3", 30.0 , "nike.com",4.2,null, "shirts")
        shop.addItemToShop(4,"Item 4", 250.0 , "guvvi.com",4.2,null, "shirts")


        val recyclerView: RecyclerView = findViewById(R.id.shop_recycler_view)
        val shopItemAdapter = ShopItemAdapter(shop.getShopItems())
        recyclerView.adapter = shopItemAdapter

        val spinner: Spinner = findViewById(R.id.sort_spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.sorting_options, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val sortedList = when (position) {
                    0 -> shop.getShopItems().sortedBy {it.name}
                    1 -> shop.getShopItems().sortedBy {it.rating}
                    2 -> shop.getShopItems().sortedBy{it.price}
                    3 -> shop.getShopItems().sortedByDescending{it.price}
                    4 -> shop.getShopItems().sortedBy{it.url}
                    5 -> shop.getShopItems().sortedBy{it.category}
                    else -> shop.getShopItems()
                }
                shop.setShopItems(sortedList)
                shopItemAdapter.notifyDataSetChanged() // Refresh the RecyclerView

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing here
            }
        }
        spinner.adapter = adapter

        val homebutton: Button = findViewById(R.id.backtohome)
        homebutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("shop", shop as Serializable)
            startActivity(intent)
        }

        val cart: Button = findViewById(R.id.goToSC)
        cart.setOnClickListener {
            val intent = Intent(this, ShoppingCartActivity::class.java)
            intent.putExtra("shop", shop as Serializable)
            startActivity(intent)
        }
    }
}



