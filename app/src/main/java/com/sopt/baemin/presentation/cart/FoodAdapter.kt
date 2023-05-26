package com.sopt.baemin.presentation.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.baemin.data.entity.FoodDummy
import com.sopt.baemin.databinding.ItemStoreFoodBinding
import com.sopt.baemin.util.ItemDiffCallback

class FoodAdapter : ListAdapter<FoodDummy, FoodAdapter.FoodViewHolder>(diffUtil) {
    class FoodViewHolder(private val binding: ItemStoreFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodDummy: FoodDummy) {
            binding.foodDummy = foodDummy
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            ItemStoreFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffUtil = ItemDiffCallback<FoodDummy>(
            onItemsTheSame = { old, new -> old === new },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}