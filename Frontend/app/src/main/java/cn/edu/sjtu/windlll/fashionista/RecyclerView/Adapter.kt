package cn.edu.sjtu.windlll.fashionista.RecyclerView

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.edu.sjtu.windlll.fashionista.Products.CartItem
import cn.edu.sjtu.windlll.fashionista.Products.Items
import cn.edu.sjtu.windlll.fashionista.R
import cn.edu.sjtu.windlll.fashionista.shoppingCart

class ShopItemAdapter(private val items: List<Items>) : RecyclerView.Adapter<ShopItemAdapter.ViewHolder>() {
    private val mutableItems: MutableList<Items> = items.toMutableList()
    // ...

    // Provide a reference to the views for each data item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.item_name)
        val RatingTextView: TextView = view.findViewById(R.id.item_Rank)
        val priceTextView: TextView = view.findViewById(R.id.item_price)
        val pictureImageView: ImageView = view.findViewById(R.id.picture_image_view)
        val addtocartButton: Button = view.findViewById(R.id.add_to_cart_button)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_items, parent, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item0 = items[position]
        holder.nameTextView.text = item0.name
        holder.RatingTextView.text = item0.rating.toString()
        holder.priceTextView.text = item0.price.toString()
        val pictureResId = item0.picture ?: R.drawable.no_image_available
        holder.pictureImageView.setImageResource(pictureResId)
        holder.addtocartButton.setOnClickListener {
            item0.ifincart = 1;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = mutableItems.size
}

class CartItemAdapter(private val items: List<CartItem>) : RecyclerView.Adapter<CartItemAdapter.ViewHolder>() {
    private val mutableItems: MutableList<CartItem> = items.toMutableList()
    // ...

    // Provide a reference to the views for each data item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.item_name)
        val quantityTextView: TextView = view.findViewById(R.id.item_Quantity)
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
            if (item.quantity > 1) {
                item.quantity--
                holder.quantityTextView.text = item.quantity.toString()
            }
            else{
                mutableItems.removeAt(position)
                item.quantity = 0
                notifyItemRemoved(position)
            }
        }
        holder.deleteButton.setOnClickListener {
            mutableItems.removeAt(position)
            item.quantity = 0
            notifyItemRemoved(position)
            //notifyItemRangeChanged(position, mutableItems.size)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = mutableItems.size
}

class ReceiptItemAdapter(private val items: List<CartItem>) : RecyclerView.Adapter<ReceiptItemAdapter.ViewHolder>() {
    private val mutableItems: MutableList<CartItem> = items.toMutableList()
    // Provide a reference to the views for each data item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.item_name)
        val quantityTextView: TextView = view.findViewById(R.id.item_Rank)
        val priceTextView: TextView = view.findViewById(R.id.item_price)
        val urLTextView: TextView = view.findViewById(R.id.item_storeURL)
        val pictureImageView: ImageView = view.findViewById(R.id.product_image)

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.receipt_items, parent, false)
        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.quantityTextView.text = item.quantity.toString()
        holder.priceTextView.text = item.price.toString()
        holder.urLTextView.text = item.url
        val pictureResId = item.picture ?: R.drawable.no_image_available
        holder.pictureImageView.setImageResource(pictureResId)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = items.size
}