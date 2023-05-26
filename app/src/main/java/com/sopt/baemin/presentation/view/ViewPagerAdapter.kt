package com.sopt.baemin.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sopt.baemin.presentation.store_list.Page01Fragment
import com.sopt.baemin.presentation.store_list.Page02Fragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Page01Fragment()
            else -> Page02Fragment()
        }
    }
}