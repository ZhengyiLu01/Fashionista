package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var button_home1:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_home1 = findViewById(R.id.button_home1);
        button_home1.setOnClickListener{//
            val intent = Intent(this,Generatemodel::class.java);
            startActivity(intent);
        }
    }
}