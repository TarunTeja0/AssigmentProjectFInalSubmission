package com.example.assigmentproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ViewPagerAdapter: PagerAdapter {

    private lateinit var context : Context;
    private lateinit var imageUrls: List<String>

    constructor(context: Context, imageUrls: List<String>) : super() {
        this.context = context
        this.imageUrls = imageUrls
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(container.context).inflate(R.layout.image_view, container,false)
       var img = view.findViewById<ImageView>(R.id.imageViewMain)

        Glide.with(context)
            .load(imageUrls.get(position))
            .optionalFitCenter()
            .into(img)

        container.addView(view)


        return view
    }

    override fun getCount(): Int {
        if(imageUrls != null){
            return imageUrls.size
        }
        return 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        var obj = `object` as View
        container.removeView( obj)
    }
}