package com.sopt.baemin.presentation.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sopt.baemin.presentation.detail.menu.MenuFragment
import com.sopt.baemin.presentation.detail.review.ReviewFragment

class DetailAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MenuFragment()
            1 -> return MenuFragment()
            else -> return ReviewFragment()
        }
    }

    companion object {
        private const val NUM_TABS = 3
    }
}
