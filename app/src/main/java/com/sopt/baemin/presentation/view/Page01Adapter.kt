package com.sopt.baemin.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.baemin.data.model.response.Datum
import com.sopt.baemin.databinding.ItemPagerBinding
import com.sopt.baemin.util.ItemDiffCallback

class Page01Adapter :
    ListAdapter<Datum, Page01Adapter.Page01ViewHolder>(
        RestaurantListDiffCallback
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Page01ViewHolder {
        return Page01ViewHolder(
            ItemPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Page01ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class Page01ViewHolder(private val binding: ItemPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Datum) {
            with(binding) {
                Glide.with(root).load(item.storeImages?.get(0)).into(imgFood1)
                Glide.with(root).load(item.storeImages?.get(1)).into(imgFood2)
                Glide.with(root).load(item.storeImages?.get(2)).into(imgFood3)

                tvStoreName.text = item.storeName ?: ""
                tvDeliveryTime.text = item.deliveryTime ?: ""
                tvListOrder.text = item.deliveryFee.toString() ?: ""

            }
        }
    }

    companion object {
        private val RestaurantListDiffCallback =
            ItemDiffCallback<Datum>(
                onItemsTheSame = { old, new -> old.storeID == new.storeID },
                onContentsTheSame = { old, new -> old == new })
    }
}