package cn.edu.sjtu.windlll.fashionista.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.math_is_fun12.testing123.CartItem
import cn.edu.sjtu.math_is_fun12.testing123.R
interface OnItemDeleteListener {
    fun onItemDelete(position: Int)
}
class CartItemAdapter(private val items: List<CartItem>) : RecyclerView.Adapter<CartItemAdapter.ViewHolder>() {
    private val mutableItems: MutableList<CartItem> = items.toMutableList()

    // ...

    // Provide a reference to the views for each data item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.item_name)
        val quantityTextView: TextView = view.findViewById(R.id.item_quantity)
        val priceTextView: TextView = view.findViewById(R.id.item_price)
        val pictureImageView: ImageView = view.findViewById(R.id.picture_image_view)
        val addButton: Button = view.findViewById(R.id.add_button)
        val removeButton: Button = view.findViewById(R.id.remove_button)
        val deleteButton: Button = view.findViewById(R.id.delete_button)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.quantityTextView.text = item.quantity.toString()
        holder.priceTextView.text = item.price.toString()
        val pictureResId = item.picture ?: R.drawable.no_image_available
        holder.pictureImageView.setImageResource(pictureResId)
        holder.addButton.setOnClickListener {
            item.quantity++
            holder.quantityTextView.text = item.quantity.toString()
        }

        holder.removeButton.setOnClickListener {
            if (item.quantity > 0) {
                item.quantity--
                holder.quantityTextView.text = item.quantity.toString()
            }
        }
        holder.deleteButton.setOnClickListener {
            mutableItems.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, mutableItems.size)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = items.size
}
