package com.example.phonecomparator.repository

import com.example.phonecomparator.api.TechSpecsAPI
import com.example.phonecomparator.model.Product


interface ProductDetailRepository {

    suspend fun getProductDetail(productId: String): List<Product>

}

class ProductDetailImpl(private val service: TechSpecsAPI = TechSpecsAPI.getApiService()): ProductDetailRepository{

    override suspend fun getProductDetail(
        productId: String
    ): List<Product> {
        val response = service.getProductDetail(productId)
        return if(response.isSuccessful){
            response.body()?.data?.product!!
        }else{
            emptyList()
        }
    }

}