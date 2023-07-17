package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Permission : AppCompatActivity() {

    lateinit var button_permission1: Button;
    lateinit var button_permission2: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        button_permission1 = findViewById(R.id.button_permission1);
        button_permission1.setOnClickListener {//
            val intent = Intent(this, Createbyphoto::class.java);
            startActivity(intent);
        }

        button_permission2 = findViewById(R.id.button_permission2);
        button_permission2.setOnClickListener {//
            val intent = Intent(this, Generatemodel::class.java);
            startActivity(intent);
        }
    }
}