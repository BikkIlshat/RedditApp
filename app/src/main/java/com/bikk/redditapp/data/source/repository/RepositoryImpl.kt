package com.bikk.redditapp.data.source.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bikk.redditapp.data.childrenmodels.Children
import com.bikk.redditapp.data.popularItemRedditModel.PopularItemRedditModel
import com.bikk.redditapp.data.source.remote.ApiSource
import com.bikk.redditapp.data.source.remote.ApiSourceImpl
import com.bikk.redditapp.data.source.remote.api.ApiService
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dataSource: ApiSource,
    private val api: ApiService
) : Repository {
    override suspend fun getData(): PopularItemRedditModel = dataSource.getData()
    override suspend fun getMoreData(): Flow<PagingData<Children>> = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { ApiSourceImpl(api) }
    ).flow
}