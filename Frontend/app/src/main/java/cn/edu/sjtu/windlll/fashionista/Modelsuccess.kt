package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Modelsuccess : AppCompatActivity() {

    lateinit var button_modelsuccess1: Button;
    lateinit var button_modelsuccess2: Button;
    lateinit var button_modelsuccess3: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modelsuccess)

        button_modelsuccess1 = findViewById(R.id.button_modelsuccess1);
        button_modelsuccess1.setOnClickListener {//
            val intent = Intent(this, Viewmodel::class.java);
            startActivity(intent);
        }

        button_modelsuccess2 = findViewById(R.id.button_modelsuccess2);
        button_modelsuccess2.setOnClickListener {//
            val intent = Intent(this, Generatemodel::class.java);
            startActivity(intent);
        }

        button_modelsuccess3 = findViewById(R.id.button_modelsuccess3);
        button_modelsuccess3.setOnClickListener {//
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }
}