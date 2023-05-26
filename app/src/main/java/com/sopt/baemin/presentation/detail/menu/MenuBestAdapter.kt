package com.sopt.baemin.presentation.detail.menu

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.baemin.data.model.response.Foods
import com.sopt.baemin.databinding.ItemDetailMenuBestBinding
import com.sopt.baemin.util.ItemDiffCallback

class MenuBestAdapter :
    ListAdapter<Foods, MenuBestAdapter.MenuViewHolder>(
        menuDiffUtil
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder {
        val itemBinding =
            ItemDetailMenuBestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MenuViewHolder(
            itemBinding
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.onBind(currentList[position])
        Log.d("asdf", currentList.toString())
    }

    class MenuViewHolder(private val binding: ItemDetailMenuBestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(food: Foods) {
            binding.data = food
            Log.d("asdf", food.toString())
        }
    }

    companion object {
        private val menuDiffUtil = ItemDiffCallback<Foods>(
            onItemsTheSame = { old, new -> old.foodId == new.foodId },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}
