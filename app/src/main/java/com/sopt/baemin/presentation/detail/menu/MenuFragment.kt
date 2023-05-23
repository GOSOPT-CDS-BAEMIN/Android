package com.sopt.baemin.presentation.detail.menu

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.sopt.baemin.R
import com.sopt.baemin.databinding.FragmentMenuBinding
import com.sopt.baemin.presentation.detail.DetailViewModel
import com.sopt.baemin.util.binding.BindingFragment

class MenuFragment : BindingFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    private val viewModel: DetailViewModel by viewModels()
    private val menuAdapter: MenuAdapter = MenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initObserve()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMenu(1)
    }

    private fun initAdapter() {
        binding.rvDetailMenu.adapter = menuAdapter
    }

    private fun initObserve() {
        viewModel.menuInfo.observe(viewLifecycleOwner) { response ->
            response.data?.let { data ->
                menuAdapter.submitList(data.foods)
            }
        }
    }
}
