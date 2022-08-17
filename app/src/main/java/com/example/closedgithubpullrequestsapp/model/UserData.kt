package com.example.closedgithubpullrequestsapp.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("login")
    val name: String,
    val avatar_url:String?
)
