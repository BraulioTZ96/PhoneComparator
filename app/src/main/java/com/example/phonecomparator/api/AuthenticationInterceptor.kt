package com.example.phonecomparator.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("X-BLOBR-KEY", "oI4pGeD6MO1uFUW0kDZy6i6gdCKfXWIk")
            .build()
        return chain.proceed(request)
    }

}