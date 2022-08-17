package com.example.closedgithubpullrequestsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.closedgithubpullrequestsapp.adapter.ClosedPullRequestAdapter
import com.example.closedgithubpullrequestsapp.databinding.ActivityMainBinding
import com.example.closedgithubpullrequestsapp.viewmodel.ClosedPullRequestViewModel

class MainActivity : AppCompatActivity() {


    private val viewModel by lazy {
        ViewModelProvider(this)[ClosedPullRequestViewModel::class.java]
    }
    private val pullRequestAdapter = ClosedPullRequestAdapter(arrayListOf())
    private val mainView: ActivityMainBinding? by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refresh()
        setUpRecyclerView()
        setUpObservables()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        mainView?.refresh?.setOnClickListener {
            viewModel.refresh()
        }
    }

    private fun refresh() {
        mainView?.errorTextView?.visibility = View.GONE
        viewModel.refresh()
    }

    private fun setUpRecyclerView() {
        mainView?.closedRequestRecyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pullRequestAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun setUpObservables() {
       viewModel.pullRequests.observe(this,{ closedPullRequest->
            if(!closedPullRequest.isNullOrEmpty()){
                pullRequestAdapter.updatePullRequestList(closedPullRequest)
            }
       })
       viewModel.error.observe(this,{ error->
           if(error) {
               mainView?.errorTextView?.visibility = View.VISIBLE
           }
           else{
               mainView?.errorTextView?.visibility = View.GONE
           }
       })

       viewModel.loading.observe(this,{ loading->
           if(loading) {
               mainView?.loadingView?.visibility = View.VISIBLE
               mainView?.refresh?.isEnabled=false
           }
           else{
               mainView?.loadingView?.visibility = View.GONE
               mainView?.refresh?.isEnabled=true
           }
       })
    }
}