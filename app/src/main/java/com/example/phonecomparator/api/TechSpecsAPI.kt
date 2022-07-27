package com.example.phonecomparator.api

import com.example.phonecomparator.model.CategorySearch
import com.example.phonecomparator.model.ProductResult
import com.example.phonecomparator.model.SmartthingSearch
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface TechSpecsAPI {

    @GET("brand/all")
    suspend fun getAllBrands()

    @GET("category/all")
    suspend fun getAllCategories()

    @GET("product/detail")
    suspend fun getProductDetail(
        @Query("productId") productId: String
    ): Response<ProductResult>

    @POST("product/search")
    suspend fun postSearchProduct(
        @Body body: CategorySearch,
        @Query("query") query: String
    ): Response<SmartthingSearch>

    companion object {

        private const val BASE_URL = "https://apis.dashboard.techspecs.io/f9g3z21kiqc0hz9s/en/v3/"
        private val interceptor = AuthenticationInterceptor()
        private var instance: TechSpecsAPI? = null

        fun getApiService(): TechSpecsAPI{
            if(instance == null){
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(TechSpecsAPI::class.java)
            }
            return instance!!
        }

    }

}