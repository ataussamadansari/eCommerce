package com.example.ecommercetask_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercetask_2.R
import com.example.ecommercetask_2.model.OrderItem

class OrderAdapter(private val items: List<OrderItem>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val prodName: TextView = view.findViewById(R.id.prodName)
        val category: TextView = view.findViewById(R.id.category)
        val price: TextView = view.findViewById(R.id.price)
        val qtyTV: TextView = view.findViewById(R.id.qtyTV)
        val incrementBtn: ImageView = view.findViewById(R.id.incrementBtn)
        val decrementBtn: ImageView = view.findViewById(R.id.decrementBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_list_layout, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageResId)
        holder.prodName.text = item.productName
        holder.category.text = item.category
        holder.price.text = item.price
        holder.qtyTV.text = item.quantity.toString()

        holder.incrementBtn.setOnClickListener {
            item.quantity++
            holder.qtyTV.text = item.quantity.toString()
        }

        holder.decrementBtn.setOnClickListener {
            if (item.quantity > 1) {
                item.quantity--
                holder.qtyTV.text = item.quantity.toString()
            }
        }
    }

    override fun getItemCount(): Int = items.size
}


/*
class OrderAdapter(private val items: List<OrderItem>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val prodName: TextView = view.findViewById(R.id.prodName)
        val category: TextView = view.findViewById(R.id.category)
        val price: TextView = view.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_list_layout, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageResId)
        holder.prodName.text = item.productName
        holder.category.text = item.category
        holder.price.text = item.price
    }

    override fun getItemCount(): Int = items.size
}
*/

