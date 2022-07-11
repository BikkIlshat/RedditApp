package com.bikk.redditapp.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.cachedIn
import com.bikk.redditapp.data.source.AppState
import com.bikk.redditapp.data.source.repository.Repository
import kotlinx.coroutines.*

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )
    private val liveData = MutableLiveData<AppState>()
    fun getLiveData(): LiveData<AppState> = liveData

    fun getData() {
        viewModelCoroutineScope.launch {
            liveData.postValue(
                AppState.Success(
                    repository.getData()
                )
            )
        }
    }

    suspend fun getMore() = repository.getMoreData().cachedIn(viewModelCoroutineScope)

    private fun handleError(throwable: Throwable) {
        liveData.postValue(AppState.Error(throwable))
    }

    override fun onCleared() {
        viewModelCoroutineScope.cancel()
        super.onCleared()
    }
}

