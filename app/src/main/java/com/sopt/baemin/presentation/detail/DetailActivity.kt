package com.sopt.baemin.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.sopt.baemin.R
import com.sopt.baemin.databinding.ActivityDetailBinding
import com.sopt.baemin.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = detailViewModel

        initAdapter()
    }

    private fun initAdapter() {
        val tabTitleArray = listOf("메뉴", "정보", "리뷰")
        binding.vpDetailViewpager.adapter = DetailAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tlDetailOption, binding.vpDetailViewpager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}
