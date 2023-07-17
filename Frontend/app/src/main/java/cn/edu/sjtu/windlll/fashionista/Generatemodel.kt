package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Generatemodel : AppCompatActivity() {

    lateinit var button_ge1: Button;
    lateinit var button_ge2: Button;
    lateinit var button_ge3: Button;
    lateinit var button_ge_back: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generatemodel)

        button_ge_back = findViewById(R.id.button_ge_back);
        button_ge_back.setOnClickListener{//
            val intent = Intent(this,MainActivity::class.java);
            startActivity(intent);
        }

        button_ge1 = findViewById(R.id.button_ge1);
        button_ge1.setOnClickListener{//
            val intent = Intent(this,Createbysize::class.java);
            startActivity(intent);
        }
    }
}