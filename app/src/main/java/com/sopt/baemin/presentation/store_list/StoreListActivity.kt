package com.sopt.baemin.presentation.store_list

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.sopt.baemin.R
import com.sopt.baemin.databinding.ActivityStorelistBinding
import com.sopt.baemin.util.binding.BindingActivity

class StoreListActivity : BindingActivity<ActivityStorelistBinding>(R.layout.activity_storelist) {
    private val tabTextList = listOf("전체", "족발·보쌈", "찜·찌개·탕", "돈가스·회·일식")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewpager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, pos ->
            tab.text = tabTextList[pos]
        }.attach()
    }
}