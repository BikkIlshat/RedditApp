package com.bikk.redditapp.data.source

sealed class AppState{
    data class Success(val data: Any) : AppState()
    data class Error(val error_ : Throwable) : AppState()
    object Loading: AppState()
}
