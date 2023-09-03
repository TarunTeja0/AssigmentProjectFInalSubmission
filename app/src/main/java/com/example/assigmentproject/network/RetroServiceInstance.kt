package com.example.assigmentproject.network

import com.example.assigmentproject.data.ProductDetails
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInstance {

    @GET("products")
    fun getDataFromAPI() : Call<ProductDetails>

}