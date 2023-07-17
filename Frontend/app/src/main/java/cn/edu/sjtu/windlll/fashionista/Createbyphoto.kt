package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Createbyphoto : AppCompatActivity() {

    lateinit var button_createbyphoto_back: Button;
    lateinit var button_createbyphoto_generate: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createbyphoto)

        button_createbyphoto_back = findViewById(R.id.button_createbyphoto_back);
        button_createbyphoto_back.setOnClickListener {//
            val intent = Intent(this, Generatemodel::class.java);
            startActivity(intent);
        }

        button_createbyphoto_generate = findViewById(R.id.button_createbyphoto_generate);
        button_createbyphoto_generate.setOnClickListener {//
            val intent = Intent(this, Modelsuccess::class.java);
            startActivity(intent);
        }
    }
}