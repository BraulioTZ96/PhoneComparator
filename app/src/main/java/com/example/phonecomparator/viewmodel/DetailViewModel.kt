package com.example.phonecomparator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonecomparator.model.Product
import com.example.phonecomparator.repository.ProductDetailImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val productDetailImpl: ProductDetailImpl,private val productId: String): ViewModel() {

    private val _productListResult = MutableLiveData<List<Product>>()
    val productListResult get() = _productListResult

    init {
        getProductDetail()
    }

    private fun getProductDetail(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = productDetailImpl.getProductDetail(productId = productId)
            _productListResult.postValue(response)
        }
    }

}