package cn.edu.sjtu.windlll.fashionista

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class Createbyphoto : AppCompatActivity() {

    lateinit var button_createbyphoto_back: Button;
    lateinit var button_createbyphoto_generate: Button;

    lateinit var button_createbyphoto_ca1: Button;
    lateinit var button_createbyphoto_ca2: Button;
    lateinit var button_createbyphoto_ca3: Button;
    lateinit var button_createbyphoto_ca4: Button;
    lateinit var imageView_photo1: ImageView;
    lateinit var imageView_photo2: ImageView;
    lateinit var imageView_photo3: ImageView;
    lateinit var imageView_photo4: ImageView;

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

        val launcher1 =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    handleCameraImage1(result.data)
                }
            }

        val launcher2 =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    handleCameraImage2(result.data)
                }
            }

        val launcher3 =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    handleCameraImage3(result.data)
                }
            }

        val launcher4 =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    handleCameraImage4(result.data)
                }
            }

        button_createbyphoto_ca1 = findViewById<Button>(R.id.button_createbyphoto_ca1)
        button_createbyphoto_ca1.setOnClickListener {
            // intent to open camera app
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher1.launch(cameraIntent)
        }

        button_createbyphoto_ca2 = findViewById<Button>(R.id.button_createbyphoto_ca2)
        button_createbyphoto_ca2.setOnClickListener {
            // intent to open camera app
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher2.launch(cameraIntent)
        }

        button_createbyphoto_ca3 = findViewById<Button>(R.id.button_createbyphoto_ca3)
        button_createbyphoto_ca3.setOnClickListener {
            // intent to open camera app
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher3.launch(cameraIntent)
        }

        button_createbyphoto_ca4 = findViewById<Button>(R.id.button_createbyphoto_ca4)
        button_createbyphoto_ca4.setOnClickListener {
            // intent to open camera app
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher4.launch(cameraIntent)
        }

    }

    private fun handleCameraImage1(intent: Intent?) {
        val bitmap = intent?.extras?.get("data") as Bitmap
        imageView_photo1 = findViewById<ImageView>(R.id.imageView_photo1)
        imageView_photo1.setImageBitmap(bitmap)
    }

    private fun handleCameraImage2(intent: Intent?) {
        val bitmap = intent?.extras?.get("data") as Bitmap
        imageView_photo2 = findViewById<ImageView>(R.id.imageView_photo2)
        imageView_photo2.setImageBitmap(bitmap)
    }

    private fun handleCameraImage3(intent: Intent?) {
        val bitmap = intent?.extras?.get("data") as Bitmap
        imageView_photo3 = findViewById<ImageView>(R.id.imageView_photo3)
        imageView_photo3.setImageBitmap(bitmap)
    }

    private fun handleCameraImage4(intent: Intent?) {
        val bitmap = intent?.extras?.get("data") as Bitmap
        imageView_photo4 = findViewById<ImageView>(R.id.imageView_photo4)
        imageView_photo4.setImageBitmap(bitmap)
    }
}