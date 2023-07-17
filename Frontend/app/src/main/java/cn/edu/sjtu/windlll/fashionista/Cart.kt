package cn.edu.sjtu.windlll.fashionista

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class Cart : AppCompatActivity() {

    private lateinit var cartItemListView: ListView
    private lateinit var refresher: SwipeRefreshLayout
    lateinit var checkoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        cartItemListView = findViewById(R.id.cartListView)
        refresher = findViewById(R.id.cartRefreshContainer)
        checkoutButton = findViewById(R.id.checkoutbox)

        checkoutButton.setOnClickListener {//
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }

    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        checkoutButton.text = "No cloth To Check Out"


        refresher.setOnRefreshListener {
            refreshTimeline()
        }
    }

    private fun refreshTimeline() {
        checkoutButton.text = "No cloth To Check Out"
        refresher.isRefreshing = false
    }


}