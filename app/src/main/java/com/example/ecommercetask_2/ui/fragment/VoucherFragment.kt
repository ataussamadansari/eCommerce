package com.example.ecommercetask_2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercetask_2.R
import com.example.ecommercetask_2.adapter.VoucherAdapter
import com.example.ecommercetask_2.model.VoucherItem

class VoucherFragment : Fragment() {

    private lateinit var voucherRecyclerView: RecyclerView
    private lateinit var voucherAdapter: VoucherAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val voucherList = listOf(
            VoucherItem("Flat ₹100 OFF", "25 July 2025", "₹500.00"),
            VoucherItem("Buy 1 Get 1", "30 July 2025", "₹299.00"),
            VoucherItem("20% Cashback", "1 Aug 2025", "₹999.00"),
            VoucherItem("20% Cashback", "1 Aug 2025", "₹999.00")
        )

        voucherRecyclerView = view.findViewById(R.id.voucher_rv)
        voucherRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        voucherAdapter = VoucherAdapter(voucherList)
        voucherRecyclerView.adapter = voucherAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_voucher, container, false)
    }

}