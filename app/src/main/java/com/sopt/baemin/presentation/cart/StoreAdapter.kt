package com.sopt.baemin.presentation.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sopt.baemin.data.model.response.Store
import com.sopt.baemin.databinding.ItemCartStoreBinding
import com.sopt.baemin.util.ItemDiffCallback

class StoreAdapter : ListAdapter<Store, StoreAdapter.StoreViewHolder>(diffUtil) {
    class StoreViewHolder(private val binding: ItemCartStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(store: Store) {
            binding.store = store
            initFoodAdapter(store)
        }

        // 한 매장을 바인딩 시킬 때마다 food adapter 재생성 (일단 해보자)
        private fun initFoodAdapter(store: Store) {
            val foodAdapter = FoodAdapter()
            binding.rvStoreFood.adapter = foodAdapter
            foodAdapter.submitList(store.foods)
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
        private val diffUtil = ItemDiffCallback<Store>(
            onItemsTheSame = { old, new -> old === new },
            onContentsTheSame = { old, new -> old == new }
        )
    }
}