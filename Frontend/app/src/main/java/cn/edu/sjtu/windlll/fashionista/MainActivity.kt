package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    lateinit var button_home1:Button;
    lateinit var button_home2:Button;
    lateinit var button_home3:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_home1 = findViewById(R.id.button_home1);
        button_home1.setOnClickListener{//
            val intent = Intent(this,Generatemodel::class.java);
            startActivity(intent);
        }

        button_home2 = findViewById(R.id.button_home2);
        button_home2.setOnClickListener{//
            val intent = Intent(this,ShopActivity::class.java);
            startActivity(intent);
        }

        button_home3 = findViewById(R.id.button_home3)
//        val shopItems = intent.getSerializableExtra("shop") as shop
        button_home3.setOnClickListener {
            val intent = Intent(this, ShoppingCartActivity::class.java)
            // Convert the cart items to a serializable or parcelable format
//            intent.putExtra("shop0", shopItems as Serializable)
            startActivity(intent)
        }
    }
}