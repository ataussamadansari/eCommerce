package com.example.ecommercetask_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercetask_2.model.FeatureItem
import com.example.ecommercetask_2.R

class FeatureAdapter(private val items: List<FeatureItem>) :
    RecyclerView.Adapter<FeatureAdapter.FeatureViewHolder>() {

    inner class FeatureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title_tv)
        val desc: TextView = view.findViewById(R.id.desc_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item_layout, parent, false)
        return FeatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeatureViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageRes)
        holder.title.text = item.title
        holder.desc.text = item.description
    }

    override fun getItemCount() = items.size
}
