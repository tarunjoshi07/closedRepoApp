package com.example.closedgithubpullrequestsapp

import android.content.ClipData
import androidx.recyclerview.widget.DiffUtil
import com.example.closedgithubpullrequestsapp.model.ClosedPullRequestData

class DiffCallback : DiffUtil.ItemCallback<ClosedPullRequestData>() {

    override fun areItemsTheSame(oldItem: ClosedPullRequestData, newItem: ClosedPullRequestData) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem:ClosedPullRequestData, newItem: ClosedPullRequestData) =
       (oldItem.title == newItem.title &&
          oldItem.closed_date == newItem.closed_date &&
          oldItem.created_date == newItem.created_date &&
          oldItem.user == newItem.user)
}

