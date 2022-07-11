package com.bikk.redditapp.data.popularItemRedditModel


import com.bikk.redditapp.data.childrenmodels.Children
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("after")
    val after: String,
    @SerializedName("before")
    val before: Any,
    @SerializedName("children")
    val children: List<Children>,

    )