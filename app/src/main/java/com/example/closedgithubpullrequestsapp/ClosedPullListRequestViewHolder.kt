package com.example.closedgithubpullrequestsapp

import androidx.recyclerview.widget.RecyclerView
import com.example.closedgithubpullrequestsapp.databinding.ItemListViewBinding
import com.example.closedgithubpullrequestsapp.model.ClosedPullRequestData
import com.example.closedgithubpullrequestsapp.utils.loadImage

class PullListRequestViewHolder(view: ItemListViewBinding): RecyclerView.ViewHolder(view.root) {
    private val title = view.title
    private val createdDate = view.createdDate
    private val closedDate = view.closedDate
    private val imageView = view.imageView
    private val username = view.userName

    fun bind(pullRequest: ClosedPullRequestData) {
        title.text = pullRequest.title
        createdDate.text = pullRequest.created_date
        closedDate.text = pullRequest.closed_date
        username.text = pullRequest.user.name
        imageView.loadImage(pullRequest.user.avatar_url)
    }
}
