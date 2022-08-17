package com.example.closedgithubpullrequestsapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.closedgithubpullrequestsapp.model.ClosedPullRequestData
import com.example.closedgithubpullrequestsapp.model.PullRequestApiInterface
import com.google.gson.JsonObject
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClosedPullRequestRepository @Inject constructor(private  var pullRequestApiInterface: PullRequestApiInterface){
    private var pullRequests=MutableLiveData<List<ClosedPullRequestData>>()
    val requests:LiveData<List<ClosedPullRequestData>>
    get() = pullRequests
    suspend  fun fetchPullRequest() {
        val result=pullRequestApiInterface.getPullRequest()
        if(result.isSuccessful && result.body()!=null){
            pullRequests.postValue(result.body())
        }
    }
}