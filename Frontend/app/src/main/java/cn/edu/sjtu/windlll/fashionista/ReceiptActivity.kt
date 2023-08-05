package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.windlll.fashionista.RecyclerView.ReceiptItemAdapter
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ReceiptActivity : AppCompatActivity() {
    private lateinit var rootView: ViewGroup
    private val shoppingCart =shoppingCart()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.receipt)
        val cartItems = intent.getSerializableExtra("shoppingCart") as shoppingCart

        // Use the cart items to populate your RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.receipt_items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ReceiptItemAdapter(cartItems.getCartItems())

        val totalPriceTextView: TextView = findViewById(R.id.total_price)
        val totalPrice = cartItems.getTotal()

        totalPriceTextView.text = "Total Price: $totalPrice"
        rootView = findViewById(android.R.id.content)


        val downloadButton: Button = findViewById(R.id.download_receipt_button)
        downloadButton.setOnClickListener {
            val bitmap = Bitmap.createBitmap(rootView.width, rootView.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            rootView.draw(canvas)

            val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
            val filename = "receipt_$timestamp.jpg"
            val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), filename)

            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.close()

            Toast.makeText(this, "Receipt saved to ${file.absolutePath}", Toast.LENGTH_LONG).show()
        }

        val goBack: Button = findViewById(R.id.go_back)
        goBack.setOnClickListener {
            finish()
        }

        val goHome: Button = findViewById(R.id.go_home)
        goHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }
}
