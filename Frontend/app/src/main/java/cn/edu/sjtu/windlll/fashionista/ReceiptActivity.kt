package cn.edu.sjtu.windlll.fashionista

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.math_is_fun12.testing123.ReceiptRecyclerView.ReceiptItemAdapter
import cn.edu.sjtu.math_is_fun12.testing123.RecyclerView.CartItemAdapter
import java.io.File
import java.io.FileOutputStream

class ReceiptActivity : AppCompatActivity() {
    private lateinit var rootView: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.receipt)
        val cartItems = intent.getSerializableExtra("cartItems") as Array<CartItem>
        // Use the cart items to populate your RecyclerView
        rootView = findViewById(android.R.id.content)


        val recyclerView: RecyclerView = findViewById(R.id.receipt_items)
        recyclerView.adapter = ReceiptItemAdapter(cartItems)
        val totalPriceTextView: TextView = findViewById(R.id.total_price)
        val totalPrice = cartItems.sumByDouble { it.price * it.quantity }

        totalPriceTextView.text = "Total Price: $totalPrice"
        val downloadButton: Button = findViewById(R.id.download_receipt_button)
        downloadButton.setOnClickListener {
            val bitmap = Bitmap.createBitmap(rootView.width, rootView.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            rootView.draw(canvas)

            val file = File(getExternalFilesDir(null), "receipt.jpg")
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.close()

            Toast.makeText(this, "Receipt saved to ${file.absolutePath}", Toast.LENGTH_LONG).show()
        }

        val goBackButton: Button = findViewById(R.id.go_back)
        goBackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }
}
