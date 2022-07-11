package com.bikk.redditapp.di

import com.bikk.redditapp.data.source.remote.ApiSource
import com.bikk.redditapp.data.source.remote.ApiSourceImpl
import com.bikk.redditapp.data.source.remote.api.RetrofitInstance
import com.bikk.redditapp.data.source.repository.Repository
import com.bikk.redditapp.data.source.repository.RepositoryImpl
import com.bikk.redditapp.ui.screens.MainFragment
import com.bikk.redditapp.ui.screens.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DI {
    fun sourceModules() = module {
        single<ApiSource> {
            ApiSourceImpl(RetrofitInstance.api)
        }
    }

    fun repositoryModule() = module {
        single<Repository> {
            RepositoryImpl(get(), RetrofitInstance.api)
        }
    }

    fun viewModules() = module {
        scope<MainFragment> {
            viewModel { MainViewModel(get()) }
        }
    }
}