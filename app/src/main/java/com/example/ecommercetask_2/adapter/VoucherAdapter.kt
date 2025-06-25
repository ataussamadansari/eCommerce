package com.example.ecommercetask_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercetask_2.model.VoucherItem
import com.example.ecommercetask_2.R

class VoucherAdapter(private val list: List<VoucherItem>) :
    RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>() {

    inner class VoucherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTV: TextView = view.findViewById(R.id.title_tv)
        val dateTV: TextView = view.findViewById(R.id.date_tv)
        val amountTV: TextView = view.findViewById(R.id.amount_tv)
        val applyBtn: AppCompatButton = view.findViewById(R.id.apply_btn) // optional if you need it
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.voucher_item_layout, parent, false)
        return VoucherViewHolder(view)
    }

    override fun onBindViewHolder(holder: VoucherViewHolder, position: Int) {
        val item = list[position]
        holder.titleTV.text = item.title
        holder.dateTV.text = item.validDate
        holder.amountTV.text = item.minTransaction
    }

    override fun getItemCount(): Int = list.size
}
