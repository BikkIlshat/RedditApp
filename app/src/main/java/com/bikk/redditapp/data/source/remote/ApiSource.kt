package com.bikk.redditapp.data.source.remote

import com.bikk.redditapp.data.popularItemRedditModel.PopularItemRedditModel

interface ApiSource {
    suspend fun getData(): PopularItemRedditModel
    suspend fun getMoreData(after: String): PopularItemRedditModel
}