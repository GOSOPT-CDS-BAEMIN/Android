package com.sopt.baemin.presentation.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.sopt.baemin.R
import com.sopt.baemin.data.entity.StoreDummy
import com.sopt.baemin.databinding.ItemCartStoreBinding
import com.sopt.baemin.util.ItemDiffCallback

class StoreAdapter : ListAdapter<StoreDummy, StoreAdapter.StoreViewHolder>(diffUtil) {
    class StoreViewHolder(private val binding: ItemCartStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(storeDummy: StoreDummy) {
            binding.storeDummy = storeDummy
            initFoodRecyclerView(storeDummy, binding.root.context)
        }

        private fun initFoodRecyclerView(storeDummy: StoreDummy, context: Context) {
            val foodAdapter = FoodAdapter()
            binding.rvStoreFood.adapter = foodAdapter
            binding.rvStoreFood.layoutManager = LinearLayoutManager(context)

            val divider = DividerItemDecoration(context, VERTICAL)
            val drawable = ContextCompat.getDrawable(context, R.drawable.recyclerview_item_divider)
            if (drawable != null) {
                divider.setDrawable(drawable)
            }
            binding.rvStoreFood.addItemDecoration(divider)

            foodAdapter.submitList(storeDummy.foods)
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