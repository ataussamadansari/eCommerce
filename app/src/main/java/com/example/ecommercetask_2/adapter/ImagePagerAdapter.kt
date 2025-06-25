package com.example.ecommercetask_2.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.ecommercetask_2.R

class ImagePagerAdapter(private val images: List<Int>) : PagerAdapter() {
    override fun getCount() = images.size

    override fun isViewFromObject(view: View, obj: Any) = view == obj

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val context = container.context
        val imageView = com.google.android.material.imageview.ShapeableImageView(context).apply {
            setImageResource(images[position])
            scaleType = ImageView.ScaleType.CENTER_CROP
            background = context.getDrawable(R.drawable.view_pager_bg)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            shapeAppearanceModel = shapeAppearanceModel
                .toBuilder()
                .setAllCornerSizes(24f) // Adjust corner radius as needed
                .build()
        }

        container.addView(imageView)
        return imageView
    }


    /* override fun instantiateItem(container: ViewGroup, position: Int): Any {
         val imageView = ImageView(container.context)
         imageView.setImageResource(images[position])
         imageView.scaleType = ImageView.ScaleType.CENTER_CROP
         container.addView(imageView)
         return imageView
     }*/

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}
