package com.example.ecommercetask_2

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ecommercetask_2.ui.fragment.HomeFragment
import com.example.ecommercetask_2.ui.fragment.OrderFragment
import com.example.ecommercetask_2.ui.fragment.ProfileFragment
import com.example.ecommercetask_2.ui.fragment.VoucherFragment

class MainActivity : AppCompatActivity() {

    private lateinit var tabIndicator: View
    private lateinit var navHome: LinearLayout
    private lateinit var navVoucher: LinearLayout
    private lateinit var navOrder: LinearLayout
    private lateinit var navProfile: LinearLayout
    private var currentTab: String = "home"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        tabIndicator = findViewById(R.id.tab_indicator)
        navHome = findViewById(R.id.nav_home_btn)
        navVoucher = findViewById(R.id.nav_voucher_btn)
        navOrder = findViewById(R.id.nav_order_btn)
        navProfile = findViewById(R.id.nav_profile_btn)


        showTab(currentTab)

        navHome.setOnClickListener {
            if (currentTab != "home") {
                showTab(currentTab = "home")
            }
        }
        navVoucher.setOnClickListener {
            if (currentTab != "voucher") {
                showTab(currentTab = "voucher")
            }
        }
        navOrder.setOnClickListener {
            if (currentTab != "order") {
                showTab(currentTab = "order")
            }
        }
        navProfile.setOnClickListener {
            if (currentTab != "profile") {
                showTab(currentTab = "profile")
            }
        }
    }

    private fun showTab(currentTab: String) {
        // Update current tab
        this.currentTab = currentTab

        val targetView = when (currentTab) {
            "home" -> navHome
            "voucher" -> navVoucher
            "order" -> navOrder
            "profile" -> navProfile
            else -> navHome
        }

        moveIndicatorTo(targetView)

        // Load corresponding fragment
        val fragment = when (currentTab) {
            "home" -> HomeFragment()
            "voucher" -> VoucherFragment()
            "order" -> OrderFragment()
            "profile" -> ProfileFragment()
            else -> HomeFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }

    private fun moveIndicatorTo(target: View) {
        tabIndicator.post {
            val x = target.x
            val width = target.width

            tabIndicator.animate()
                .x(x)
                .setDuration(200)
                .start()

            val layoutParams = tabIndicator.layoutParams
            layoutParams.width = width
            tabIndicator.layoutParams = layoutParams
        }
    }
}