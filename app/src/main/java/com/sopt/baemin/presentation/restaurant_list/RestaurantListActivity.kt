package com.sopt.baemin.presentation.restaurant_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.sopt.baemin.databinding.ActivityMainBinding
import com.sopt.baemin.presentation.view.ViewPagerAdapter

class RestaurantListActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val tabTextList = listOf("전체","족발·보쌈","찜·찌개·탕","돈가스·회·일식")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewpager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tablayout,binding.viewpager){
            tab,pos->
            tab.text = tabTextList[pos]
        }.attach()
    }
}