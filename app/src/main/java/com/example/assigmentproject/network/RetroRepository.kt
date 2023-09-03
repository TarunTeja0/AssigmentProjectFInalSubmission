package com.example.assigmentproject.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.assigmentproject.data.Product
import com.example.assigmentproject.data.ProductDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroInstance : RetroServiceInstance){

    fun makeApiCall(liveDataList: MutableLiveData<List<Product>>){
        val call : Call<ProductDetails> = retroInstance.getDataFromAPI()
        call.enqueue(object : Callback<ProductDetails>{
            override fun onResponse(call: Call<ProductDetails>, response: Response<ProductDetails>) {
                liveDataList.postValue(response.body()?.products!!)
                Log.d("retrofit","onresponse")
            }

            override fun onFailure(call: Call<ProductDetails>, t: Throwable) {
                liveDataList.postValue(null)
                Log.d("retrofit","onFailure")

            }

        })
    }
}