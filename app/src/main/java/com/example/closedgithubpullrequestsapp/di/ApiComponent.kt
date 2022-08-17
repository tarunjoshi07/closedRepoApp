package com.example.closedgithubpullrequestsapp.di

import com.example.closedgithubpullrequestsapp.MainActivity
import com.example.closedgithubpullrequestsapp.repository.ClosedPullRequestRepository
import com.example.closedgithubpullrequestsapp.viewmodel.ClosedPullRequestViewModel
import dagger.Component


@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(viewModel: ClosedPullRequestViewModel)
}