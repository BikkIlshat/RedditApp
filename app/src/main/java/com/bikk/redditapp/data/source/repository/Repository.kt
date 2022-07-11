package com.bikk.redditapp.data.source.repository

import androidx.paging.PagingData
import com.bikk.redditapp.data.childrenmodels.Children
import com.bikk.redditapp.data.popularItemRedditModel.PopularItemRedditModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(): PopularItemRedditModel
    suspend fun getMoreData(): Flow<PagingData<Children>>
}