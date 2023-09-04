package com.example.assigmentproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.assigmentproject.data.Product
import me.relex.circleindicator.CircleIndicator

class DetailsActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var circleIndicator: CircleIndicator
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var product: Product
    private lateinit var productName: TextView
    private lateinit var sellingPrice: TextView
    private lateinit var discount: TextView
    private lateinit var originalPrice: TextView
    private lateinit var rating: TextView
    private lateinit var category: TextView
    private lateinit var brand: TextView
    private lateinit var stock: TextView
    private lateinit var description: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        product = intent.getParcelableExtra("product")!!
        init()

        assignValuesToFields()


//        val getData = intent.getStringExtra("tarun")

    }

    @SuppressLint("SetTextI18n")
    private fun assignValuesToFields() {
        productName.text = product.title
        sellingPrice.text = "Rs.${product.price}"
        discount.text = "${product.discountPercentage}%"
        var discInFloat : Float = 1 - (product.discountPercentage/100).toFloat()
        originalPrice.text = "Rs."+(product.price/discInFloat).toInt().toString()
        rating.text = product.rating.toString() + "/5"
        category.text = product.category
        brand.text = product.brand
        stock.text = product.stock.toString()
        description.text = product.description

    }

    private fun init(){
        productName = findViewById(R.id.product_name)
        sellingPrice = findViewById(R.id.selling_price)
        discount = findViewById(R.id.discount)
        originalPrice = findViewById(R.id.original_price)
        rating = findViewById(R.id.rating)
        category = findViewById(R.id.category)
        brand = findViewById(R.id.brand)
        stock = findViewById(R.id.stock)
        description = findViewById(R.id.description)
        viewPager = findViewById(R.id.viewPager)
        circleIndicator = findViewById(R.id.circle_indicator)



        viewPagerAdapter = ViewPagerAdapter(this,product.images)
        viewPager.adapter = viewPagerAdapter

        circleIndicator.setViewPager(viewPager)
        viewPagerAdapter.registerDataSetObserver(circleIndicator.dataSetObserver)
    }
}
