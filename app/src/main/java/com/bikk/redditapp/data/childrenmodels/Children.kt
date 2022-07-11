package com.bikk.redditapp.data.childrenmodels

import com.google.gson.annotations.SerializedName


data class Children(
    @SerializedName("data")
    val childrenData: ChildrenData,

    )