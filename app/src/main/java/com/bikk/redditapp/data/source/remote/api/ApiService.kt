package com.bikk.redditapp.data.source.remote.api

import com.bikk.redditapp.data.popularItemRedditModel.PopularItemRedditModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top.json")
    suspend fun getPosts(): PopularItemRedditModel

    @GET("top.json")
    suspend fun getMorePosts(@Query("after") after: String): PopularItemRedditModel
}