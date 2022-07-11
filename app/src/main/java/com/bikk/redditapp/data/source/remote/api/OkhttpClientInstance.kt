package com.bikk.redditapp.data.source.remote.api

import okhttp3.OkHttpClient

object OkhttpClientInstance {
    fun getOkHttpClientBuilder(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            }
        return httpClient.build()
    }
}