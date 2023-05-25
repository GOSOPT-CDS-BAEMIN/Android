package com.sopt.baemin.presentation.cart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.baemin.R
import com.sopt.baemin.databinding.ActivityCartBinding
import com.sopt.baemin.util.binding.BindingActivity
import com.sopt.baemin.util.extension.showSnackbar
import com.sopt.baemin.util.state.RemoteUiState
import com.sopt.baemin.util.state.RemoteUiState.*

class CartActivity : BindingActivity<ActivityCartBinding>(R.layout.activity_cart) {
    private val viewModel by viewModels<CartViewModel>()
    private var cartAdapter: CartAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        initCartRecyclerView()
        initCartListStateObserver()
    }

    private fun initCartListStateObserver() {
        viewModel.getCartListState.observe(this) { state ->
            when (state) {
                is Success -> cartAdapter?.submitList(viewModel.cartList)
                is Failure -> showSnackbar(
                    binding.root,
                    getString(R.string.cart_list_empty_err_msg)
                )
                is Error -> showSnackbar(binding.root, getString(R.string.network_err_msg))
            }
        }
    }

    private fun initCartRecyclerView() {
        cartAdapter = CartAdapter()
        binding.rvCartStore.adapter = cartAdapter
        binding.rvCartStore.layoutManager = LinearLayoutManager(this)
    }
}