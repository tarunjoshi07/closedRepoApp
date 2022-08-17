package com.example.closedgithubpullrequestsapp.model

import com.google.gson.annotations.SerializedName

data class ClosedPullRequestData(
    val title:String?,
    @SerializedName("created_at")
    val created_date:String?,
    @SerializedName("closed_at")
    val closed_date:String?,
    val user:UserData
)
