package com.example.assigmentproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assigmentproject.data.Product
import com.example.assigmentproject.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository :  RetroRepository) : ViewModel(){
    var liveDataList : MutableLiveData<List<Product>>

    init {
        liveDataList = MutableLiveData()
    }

    fun  getLiveDataObserver() : MutableLiveData<List<Product>>{
        return liveDataList
    }
    fun loadListOfData(){
        repository.makeApiCall(liveDataList)
    }
}