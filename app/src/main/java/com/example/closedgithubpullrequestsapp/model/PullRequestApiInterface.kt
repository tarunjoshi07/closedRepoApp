package com.example.closedgithubpullrequestsapp.model

import retrofit2.Response
import retrofit2.http.GET

interface PullRequestApiInterface {
    @GET("repos/prakashshuklahub/Pull-Request-GithubApi-Demo-App/pulls?state=closed")
    suspend  fun getPullRequest(): Response<List<ClosedPullRequestData>>
}