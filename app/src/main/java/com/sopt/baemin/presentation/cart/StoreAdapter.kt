package com.sopt.baemin.presentation.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.baemin.data.entity.StoreDummy
import com.sopt.baemin.data.model.response.Store
import com.sopt.baemin.databinding.ItemCartStoreBinding
import com.sopt.baemin.util.ItemDiffCallback

class StoreAdapter : ListAdapter<StoreDummy, StoreAdapter.StoreViewHolder>(diffUtil) {
    class StoreViewHolder(private val binding: ItemCartStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(storeDummy: StoreDummy) {
            binding.storeDummy = storeDummy

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            ItemCartStoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffUtil = ItemDiffCallback<StoreDummy>(
            onItemsTheSame = { old, new -> old === new },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}