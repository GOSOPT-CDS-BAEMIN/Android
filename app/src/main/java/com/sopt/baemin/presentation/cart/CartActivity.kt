package com.sopt.baemin.presentation.cart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.baemin.R
import com.sopt.baemin.databinding.ActivityCartBinding
import com.sopt.baemin.util.binding.BindingActivity
import com.sopt.baemin.util.extension.showSnackbar
import com.sopt.baemin.util.state.RemoteUiState.*

class CartActivity : BindingActivity<ActivityCartBinding>(R.layout.activity_cart) {
    private val viewModel by viewModels<CartViewModel>()
    private val storeAdapter by lazy { StoreAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        initCartRecyclerView()
        initCartListStateObserver()
    }

    private fun initCartRecyclerView() {
        binding.rvCartStore.adapter = storeAdapter
        binding.rvCartStore.layoutManager = LinearLayoutManager(this)
    }

    private fun initCartListStateObserver() {
        viewModel.getCartListState.observe(this) { state ->
            when (state) {
                is Success -> storeAdapter.submitList(viewModel.storeList)
                is Failure -> showSnackbar(
                    binding.root,
                    getString(R.string.cart_list_empty_err_msg)
                )
                is Error -> showSnackbar(binding.root, getString(R.string.network_err_msg))
            }
        }
    }
}