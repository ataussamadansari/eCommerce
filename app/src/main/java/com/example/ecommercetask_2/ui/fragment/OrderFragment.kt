package com.example.ecommercetask_2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercetask_2.R
import com.example.ecommercetask_2.adapter.OrderAdapter
import com.example.ecommercetask_2.model.OrderItem


class OrderFragment : Fragment() {


    private lateinit var orderRecyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderRecyclerView = view.findViewById(R.id.orderRecyclerView)

        val sampleOrders = listOf(
            OrderItem(R.drawable.sample_1, "iPhone 14 Pro Max", "Electronics", "₹1,29,999"),
            OrderItem(R.drawable.sample_2, "Adidas Running Shoes", "Footwear", "₹4,499"),
            OrderItem(R.drawable.sample_3, "Fossil Smartwatch", "Accessories", "₹9,999")
        )

        orderAdapter = OrderAdapter(sampleOrders)
        orderRecyclerView.adapter = orderAdapter
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }
}