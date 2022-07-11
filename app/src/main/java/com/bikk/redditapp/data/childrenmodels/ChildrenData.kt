package com.bikk.redditapp.data.childrenmodels


import com.google.gson.annotations.SerializedName

data class ChildrenData(

    @SerializedName("author_fullname")
    val authorFullname: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("created")
    val created: Double,
    @SerializedName("num_comments")
    val numComments: Int,
    @SerializedName("total_awards_received")
    val totalAwardsReceived: Int,
    @SerializedName("name")
    val name: String,

)