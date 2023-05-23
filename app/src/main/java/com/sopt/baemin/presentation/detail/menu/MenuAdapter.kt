package com.sopt.baemin.presentation.detail.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.baemin.data.model.response.Foods
import com.sopt.baemin.databinding.ItemDetailMenuFoodBinding
import com.sopt.baemin.util.ItemDiffCallback

class MenuAdapter :
    ListAdapter<Foods, MenuAdapter.MenuViewHolder>(
        menuDiffUtil
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder {
        val itemBinding =
            ItemDetailMenuFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MenuViewHolder(
            itemBinding
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MenuViewHolder(private val binding: ItemDetailMenuFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(food: Foods) {
            binding.data = food
        }
    }

    companion object {
        private val menuDiffUtil = ItemDiffCallback<Foods>(
            onItemsTheSame = { old, new -> old.foodId == new.foodId },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
