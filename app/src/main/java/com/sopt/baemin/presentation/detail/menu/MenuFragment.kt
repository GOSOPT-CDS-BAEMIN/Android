package com.sopt.baemin.presentation.detail.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.baemin.R
import com.sopt.baemin.databinding.FragmentMenuBinding
import com.sopt.baemin.presentation.detail.DetailViewModel
import com.sopt.baemin.util.binding.BindingFragment

class MenuFragment : BindingFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    private val viewModel: DetailViewModel by viewModels()
    private val menuBestAdapter: MenuBestAdapter = MenuBestAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        initView()
        initAdapter()
        initObserve()
    }

    private fun initView() {
        viewModel.getMenu(1)
    }

    private fun initAdapter() {
        binding.rvDetailMenu.adapter = menuBestAdapter
    }

    private fun initObserve() {
        viewModel.menuInfo.observe(viewLifecycleOwner) {
            menuBestAdapter.submitList(it.data.foods.toMutableList())
        }
    }
}
