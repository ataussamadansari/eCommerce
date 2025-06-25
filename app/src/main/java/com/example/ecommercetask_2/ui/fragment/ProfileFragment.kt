package com.example.ecommercetask_2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercetask_2.R
import com.example.ecommercetask_2.adapter.OptionAdapter
import com.example.ecommercetask_2.model.OptionItem


class ProfileFragment : Fragment() {
    private lateinit var optionRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        optionRecyclerView = view.findViewById(R.id.optionRV)

        val options = listOf(
            OptionItem(R.drawable.ic_user, "My Profile"),
            OptionItem(R.drawable.ic_order, "My Orders"),
            OptionItem(R.drawable.ic_coupon, "My Coupons"),
            OptionItem(R.drawable.ic_logout, "Logout")
        )

        optionRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = OptionAdapter(options) { item ->
            Toast.makeText(requireContext(), "Clicked: ${item.title}", Toast.LENGTH_SHORT).show()
            // TODO: navigate to another fragment if needed
        }

        optionRecyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}