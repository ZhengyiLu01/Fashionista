package cn.edu.sjtu.windlll.fashionista.ReceiptRecyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.math_is_fun12.testing123.CartItem
import cn.edu.sjtu.math_is_fun12.testing123.R

class ReceiptItemAdapter(private val items: Array<CartItem>) : RecyclerView.Adapter<ReceiptItemAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.item_name)
        val quantityTextView: TextView = view.findViewById(R.id.item_quantity)
        val priceTextView: TextView = view.findViewById(R.id.item_price)
        val urLTextView: TextView = view.findViewById(R.id.item_storeURL)
        val pictureImageView: ImageView = view.findViewById(R.id.picture_image_view)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.quantityTextView.text = item.quantity.toString()
        holder.priceTextView.text = item.price.toString()
        holder.nameTextView.text = item.url
        val pictureResId = item.picture ?: R.drawable.no_image_available
        holder.pictureImageView.setImageResource(pictureResId)


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = items.size
}
