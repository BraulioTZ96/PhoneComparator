package com.example.phonecomparator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.phonecomparator.repository.ProductDetailImpl
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val productDetailRepository: ProductDetailImpl, private val productId: String): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(productDetailRepository, productId) as T
        throw IllegalArgumentException("Unknown ViewModel")
    }

}