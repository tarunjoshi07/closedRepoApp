package com.example.closedgithubpullrequestsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.closedgithubpullrequestsapp.DiffCallback
import com.example.closedgithubpullrequestsapp.PullListRequestViewHolder
import com.example.closedgithubpullrequestsapp.R
import com.example.closedgithubpullrequestsapp.model.ClosedPullRequestData

class ClosedPullRequestAdapter(private var pullRequest: ArrayList<ClosedPullRequestData>): RecyclerView.Adapter<PullListRequestViewHolder>() {

    private val differCallback= DiffCallback()

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = PullListRequestViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_view, parent, false)

    )

    override fun onBindViewHolder(holder: PullListRequestViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size
}