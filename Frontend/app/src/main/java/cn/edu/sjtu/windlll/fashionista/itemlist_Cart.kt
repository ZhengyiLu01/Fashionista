package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class itemlist_Cart : AppCompatActivity() {

    lateinit var cart_remove: Button
    lateinit var button_link: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itemlistcart)

        cart_remove = findViewById(R.id.cart_remove);
        cart_remove.setOnClickListener{//
            val intent = Intent(this,Cart::class.java);
            startActivity(intent);
        }

        button_link = findViewById(R.id.button_link);
        button_link.setOnClickListener{//
            val intent = Intent(this,LinkCart::class.java);
            startActivity(intent);
        }
    }
}