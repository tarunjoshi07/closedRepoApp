package com.example.closedgithubpullrequestsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.closedgithubpullrequestsapp.di.DaggerApiComponent
import com.example.closedgithubpullrequestsapp.model.ClosedPullRequestData
import com.example.closedgithubpullrequestsapp.model.PullRequestApiInterface
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClosedPullRequestViewModel() : ViewModel() {

    @Inject
    lateinit  var pullRequestApiInterface: PullRequestApiInterface
    init {
        DaggerApiComponent.create().inject(this)
    }

    var pullRequests=MutableLiveData<List<ClosedPullRequestData>>()
    var error=MutableLiveData(false)
    var loading=MutableLiveData(false)

    fun refresh(){
        viewModelScope.launch {
            fetchPullRequest()
        }
    }

     private suspend fun fetchPullRequest() {
        loading.postValue(true)
        val result=pullRequestApiInterface.getPullRequest()
        if(result.isSuccessful && result.body()!=null){
            pullRequests.postValue(result.body())
            loading.postValue(false)
        }
        else{
            error.postValue(true)
            loading.postValue(false)
        }
    }
}