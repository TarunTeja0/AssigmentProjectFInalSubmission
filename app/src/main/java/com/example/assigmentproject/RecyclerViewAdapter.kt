package com.example.assigmentproject

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assigmentproject.data.Product



class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    private var listData: List<Product>? = null

    var onItemClick : ((Product) -> Unit)? = null

    fun setListData(listData: List<Product>) {
        this.listData = listData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(listData!![position])
        }
    }

    override fun getItemCount(): Int {
        if(listData ==null){
            return  0
        }
        else {
            return listData?.size!!
        }
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val thumbnail = view.findViewById<ImageView>(R.id.thumbnail)
        val title = view.findViewById<TextView>(R.id.title)
        val discPrice = view.findViewById<TextView>(R.id.discounted_price)
        val origiPrice = view.findViewById<TextView>(R.id.original_price)
        val rating = view.findViewById<TextView>(R.id.rating)
        lateinit var thumbUrl : String

        @SuppressLint("SetTextI18n")
        fun bind(data: Product){
            title.text = data.title
            discPrice.text= "Rs.${data.price}"
            origiPrice.text = data.discountPercentage.toString()

            val discInFloat : Float =  1-(data.discountPercentage/100).toFloat()
            origiPrice.text = "Rs."+(data.price/discInFloat).toInt().toString()
            origiPrice.setPaintFlags(origiPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
            rating.text = data.rating.toString()
            thumbUrl = data.thumbnail
            Glide.with(thumbnail)
                .load(thumbUrl)
                .into(thumbnail)
        }
    }
}