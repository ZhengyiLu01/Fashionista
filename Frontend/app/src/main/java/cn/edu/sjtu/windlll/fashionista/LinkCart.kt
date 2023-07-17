package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LinkCart : AppCompatActivity() {

    lateinit var button_link_back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link_cart)

        button_link_back = findViewById(R.id.button_link_back);
        button_link_back.setOnClickListener{//
            val intent = Intent(this,itemlist_Cart::class.java);
            startActivity(intent);
        }
    }
}