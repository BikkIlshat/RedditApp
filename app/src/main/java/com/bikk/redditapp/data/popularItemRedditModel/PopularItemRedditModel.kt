package com.bikk.redditapp.data.popularItemRedditModel


import com.google.gson.annotations.SerializedName

data class PopularItemRedditModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("kind")
    val kind: String
)