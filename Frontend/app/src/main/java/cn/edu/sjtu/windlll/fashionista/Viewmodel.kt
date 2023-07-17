package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Viewmodel : AppCompatActivity() {

    lateinit var button_Viewmodel_back: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        button_Viewmodel_back = findViewById(R.id.button_Viewmodel_back);
        button_Viewmodel_back.setOnClickListener {//
            val intent = Intent(this, Generatemodel::class.java);
            startActivity(intent);
        }
    }
}