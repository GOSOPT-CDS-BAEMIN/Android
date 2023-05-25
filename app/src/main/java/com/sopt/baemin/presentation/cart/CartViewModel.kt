package com.sopt.baemin.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.baemin.data.api.ApiFactory.ServicePool.cartService
import com.sopt.baemin.data.model.request.RequestPostCartItemDto
import com.sopt.baemin.data.model.response.BaseResponse
import com.sopt.baemin.data.model.response.ResponseGetCartListDto.*
import com.sopt.baemin.util.state.RemoteUiState
import com.sopt.baemin.util.state.RemoteUiState.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber

class CartViewModel : ViewModel() {
    private val _cartList = MutableLiveData<List<Store>>()
    val cartList: List<Store>?
        get() = _cartList.value

    private val _getCartListState = MutableLiveData<RemoteUiState>()
    val getCartListState: LiveData<RemoteUiState>
        get() = _getCartListState

    init {
        postCartItem()
        getCartList()
    }

    private fun postCartItem() {
        viewModelScope.launch {
            postCartItemResult()
                .onSuccess { response ->
                    Timber.d("POST CART ITEM SUCCESS")
                    Timber.d("${response.status} ${response.success} ${response.message}")
                }
                .onFailure { t ->
                    if (t is HttpException) {
                        Timber.e("POST CART ITEM FAIL ${t.code()} : ${t.message}}")
                    }
                }
        }
    }

    private suspend fun postCartItemResult(): Result<BaseResponse<Any>> = kotlin.runCatching {
        val requestBody = RequestPostCartItemDto(
            1,
            2,
            1
        )
        cartService.postCartItem(requestBody)
    }

    private fun getCartList() {
        viewModelScope.launch {
            getCartListResult()
                .onSuccess { cartList ->
                    if (cartList.isEmpty()) {
                        _getCartListState.value = Failure(null)
                        Timber.e("GET CART LIST FAIL : EMPTY!!!")
                        return@onSuccess
                    }

                    _cartList.value = cartList
                    _getCartListState.value = Success
                    Timber.d("GET CART LIST SUCCESS : $cartList")
                }
                .onFailure { t ->
                    if (t is HttpException) {
                        _getCartListState.value = Error
                        Timber.e("GET CART LIST FAIL ${t.code()} : ${t.message}}")
                    }
                }
        }
    }

    private suspend fun getCartListResult(): Result<List<Store>> = runCatching {
        cartService.getCartList().stores
    }
}
