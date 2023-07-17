package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


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

        button_home3 = findViewById(R.id.button_home3);
        button_home3.setOnClickListener{//
            val intent = Intent(this,itemlist_Cart::class.java);
            startActivity(intent);
        }
    }
}