package com.sopt.baemin.presentation.cart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.baemin.R
import com.sopt.baemin.data.model.response.Store
import com.sopt.baemin.databinding.ActivityCartBinding
import com.sopt.baemin.util.binding.BindingActivity
import com.sopt.baemin.util.extension.showSnackbar
import com.sopt.baemin.util.state.RemoteUiState.*

class CartActivity : BindingActivity<ActivityCartBinding>(R.layout.activity_cart) {
    private val viewModel by viewModels<CartViewModel>()
    private val storeAdapter by lazy { StoreAdapter() }
    private var totalOrderAmount = 0
    private var totalPayAmount = 0

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
                is Success -> {
                    viewModel.storeList?.let { it ->
                        storeAdapter.submitList(it)
                        updateTextView(it)
                    }
                }
                is Failure -> showSnackbar(
                    binding.root,
                    getString(R.string.cart_list_empty_err_msg)
                )
                is Error -> showSnackbar(binding.root, getString(R.string.network_err_msg))
            }
        }
    }

    private fun updateTextView(stores: List<Store>) {
        updateTotalOrderAmount(stores)
        updateTotalPayAmount(stores)
        updateOrderButtonText(stores)
    }

    private fun updateTotalOrderAmount(storeList: List<Store>) {
        for (store in storeList) {
            for (food in store.foods) {
                totalOrderAmount += food.price * food.foodCount
            }
        }
        binding.tvOrderAmount.text = getString(R.string.cart_item_price).format(totalOrderAmount)
    }

    private fun updateTotalPayAmount(storeList: List<Store>) {
        totalPayAmount = totalOrderAmount
        for (store in storeList) {
            totalPayAmount += store.deliveryFee
        }
        binding.tvPayAmount.text = getString(R.string.cart_item_price).format(totalPayAmount)
    }

    private fun updateOrderButtonText(stores: List<Store>) {
        var totalOrderNum = 0
        for(store in stores){
            totalOrderNum += store.foods.size
        }
        binding.tvTotalOrderNum.text = totalOrderNum.toString()
        binding.btnLastOrder.text = getString(R.string.cart_total_order_btn_text).format(totalPayAmount)
    }
}