package com.sopt.baemin.presentation.cart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sopt.baemin.R
import com.sopt.baemin.data.entity.FoodDummy
import com.sopt.baemin.data.entity.StoreDummy
import com.sopt.baemin.data.model.response.Food
import com.sopt.baemin.data.model.response.Store
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
        initDummyData()

        //initCartListStateObserver()
    }

    private fun initDummyData() {
        val dummyStores = mutableListOf(
            StoreDummy(1, "산시 도삭면", 3000, listOf(
                FoodDummy(1, "짬뽕 도삭면", 13000, R.drawable.ic_food_1, 1),
                FoodDummy(2, "유발면", 11000, R.drawable.ic_food_2, 1)
            ), 27000),
            StoreDummy(2, "츄로 101", 3000, listOf(
                FoodDummy(1, "플레인 츄러스", 5000, R.drawable.ic_food_3, 2),
            ), 13000),
            StoreDummy(3, "밀양돼지국밥", 3000, listOf(
                FoodDummy(1, "고기국밥", 7500, R.drawable.ic_food_4, 1),
            ), 10500),
        )
        storeAdapter.submitList(dummyStores)

        binding.tvOrderAmount.text = "41,500원"
        binding.tvPayAmount.text = "50,500원"
    }

    private fun initCartRecyclerView() {
        binding.rvCartStore.adapter = storeAdapter
        binding.rvCartStore.layoutManager = LinearLayoutManager(this)
    }

//    private fun initCartListStateObserver() {
//        viewModel.getCartListState.observe(this) { state ->
//            when (state) {
//                is Success -> storeAdapter.submitList(viewModel.storeList)
//                is Failure -> showSnackbar(
//                    binding.root,
//                    getString(R.string.cart_list_empty_err_msg)
//                )
//                is Error -> showSnackbar(binding.root, getString(R.string.network_err_msg))
//            }
//        }
//    }
}