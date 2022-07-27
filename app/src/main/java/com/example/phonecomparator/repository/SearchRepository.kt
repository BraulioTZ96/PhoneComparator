package com.example.phonecomparator.repository

import com.example.phonecomparator.api.TechSpecsAPI
import com.example.phonecomparator.model.CategorySearch
import com.example.phonecomparator.model.DataSmart

interface SearchRepository {

    suspend fun getSearchProduct(body: CategorySearch, productToSearch: String): DataSmart

}

class SearchRepositoryImpl(private val service: TechSpecsAPI = TechSpecsAPI.getApiService()): SearchRepository{

    override suspend fun getSearchProduct(
        body: CategorySearch,
        productToSearch: String
    ): DataSmart {
        val response = service.postSearchProduct(body, productToSearch)
        return if(response.isSuccessful){
            response.body()?.data!!
        }else{
            DataSmart(emptyList())
        }
    }

}