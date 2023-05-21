package com.sopt.baemin.presentation.detail.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.baemin.data.model.response.Review
import com.sopt.baemin.databinding.ItemDetailReviewBinding
import com.sopt.baemin.util.ItemDiffCallback

class ReviewAdapter :
    ListAdapter<Review, ReviewAdapter.ReviewViewHolder>(
        menuDiffUtil
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewViewHolder {
        val itemBinding =
            ItemDetailReviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ReviewViewHolder(
            itemBinding
        )
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ReviewViewHolder(private val binding: ItemDetailReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(review: Review) {
            binding.data = review
        }
    }

    companion object {
        private val menuDiffUtil = ItemDiffCallback<Review>(
            onItemsTheSame = { old, new -> old.nickname == new.nickname },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
