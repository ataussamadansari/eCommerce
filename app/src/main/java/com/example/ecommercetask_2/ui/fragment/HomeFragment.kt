package com.example.ecommercetask_2.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.ecommercetask_2.R
import com.example.ecommercetask_2.adapter.FeatureAdapter
import com.example.ecommercetask_2.adapter.ForYouAdapter
import com.example.ecommercetask_2.adapter.ImagePagerAdapter
import com.example.ecommercetask_2.model.FeatureItem

class HomeFragment : Fragment() {

    private lateinit var notificationBtn : ImageView

    private lateinit var featureRecyclerView: RecyclerView
    private val featureList = listOf(
        FeatureItem(R.drawable.ic_order, "Pick Up", "Pick up orders"),
        FeatureItem(R.drawable.ic_coupon, "Voucher", "Use available vouchers"),
        FeatureItem(R.drawable.ic_delivery, "Delivery", "Fast delivery options")
    )
    private lateinit var forYouRecyclerView: RecyclerView
    private val forYouList = listOf(
        FeatureItem(R.drawable.refer, "Discount 75%", "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed."),
        FeatureItem(R.drawable.delivery_pick, "Delivery", "Fast delivery options")
    )

    private lateinit var viewPager: ViewPager
    private lateinit var dotsLayout: LinearLayout
    private val imageList = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4
    )

    private var currentPage = 0
    private val autoSlideDelay = 3000L // 3 seconds
    private val slideHandler = Handler(Looper.getMainLooper())

    private val slideRunnable = object : Runnable {
        override fun run() {
            if (imageList.isNotEmpty()) {
                currentPage = (currentPage + 1) % imageList.size
                viewPager.setCurrentItem(currentPage, true)
                slideHandler.postDelayed(this, autoSlideDelay)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationBtn = view.findViewById(R.id.noti_btn)
        viewPager = view.findViewById(R.id.viewPager2)
        dotsLayout = view.findViewById(R.id.dot_indi_ll)

        // Order Now RecyclerView setup
        featureRecyclerView = view.findViewById(R.id.order_rv)
        featureRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        featureRecyclerView.adapter = FeatureAdapter(featureList)

        // For You RecyclerView setup
        forYouRecyclerView = view.findViewById(R.id.for_you_rv)
        forYouRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        forYouRecyclerView.adapter = ForYouAdapter(forYouList)

        val adapter = ImagePagerAdapter(imageList)
        viewPager.adapter = adapter

        setupDotIndicators(imageList.size)
        setCurrentDot(0)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(pos: Int, offset: Float, offsetPx: Int) {}
            override fun onPageSelected(position: Int) {
                currentPage = position
                setCurrentDot(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        notificationBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Notification Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        slideHandler.postDelayed(slideRunnable, autoSlideDelay)
    }

    override fun onPause() {
        super.onPause()
        slideHandler.removeCallbacks(slideRunnable)
    }

    private fun setupDotIndicators(count: Int) {
        dotsLayout.removeAllViews()
        for (i in 0 until count) {
            val dot = ImageView(requireContext())
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            dot.layoutParams = params
            dot.setImageResource(R.drawable.dot_inactive)
            dotsLayout.addView(dot)
        }
    }

    private fun setCurrentDot(index: Int) {
        for (i in 0 until dotsLayout.childCount) {
            val dot = dotsLayout.getChildAt(i) as ImageView
            dot.setImageResource(
                if (i == index) R.drawable.dot_active else R.drawable.dot_inactive
            )
        }
    }
}