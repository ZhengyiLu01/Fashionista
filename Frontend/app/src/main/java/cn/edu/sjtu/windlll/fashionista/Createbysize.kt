package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Createbysize : AppCompatActivity() {

    lateinit var button_create_back: Button;
    lateinit var button_create_generate: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createbysize)

        button_create_back = findViewById(R.id.button_create_back);
        button_create_back.setOnClickListener{//
            val intent = Intent(this,Generatemodel::class.java);
            startActivity(intent);
        }

        button_create_generate = findViewById(R.id.button_create_generate);
        button_create_generate.setOnClickListener{//
            val intent = Intent(this,Modelsuccess::class.java);
            startActivity(intent);
        }

    }
}