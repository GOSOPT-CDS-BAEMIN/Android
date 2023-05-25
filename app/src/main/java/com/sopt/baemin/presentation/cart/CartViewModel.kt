package com.sopt.baemin.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.baemin.data.api.ApiFactory.ServicePool.cartService
import com.sopt.baemin.data.model.request.RequestPostCartItemDto
import com.sopt.baemin.data.model.response.BaseResponse
import com.sopt.baemin.data.model.response.Food
import com.sopt.baemin.data.model.response.Store
import com.sopt.baemin.util.state.RemoteUiState
import com.sopt.baemin.util.state.RemoteUiState.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber

class CartViewModel : ViewModel() {
    private val _storeList = MutableLiveData<List<Store>>()
    val storeList: List<Store>?
        get() = _storeList.value

    // 매장, 음식 리스트가 모두 조회된 경우에만 성공
    private val _getCartListState = MutableLiveData<RemoteUiState>()
    val getCartListState: LiveData<RemoteUiState>
        get() = _getCartListState

    init {
        //postCartItem()
        getCartList()
    }

    private fun getCartList() {
        viewModelScope.launch {
            getStoreListResult()
                .onSuccess { stores ->
                    // 가게 리스트에 대한 처리
                    if (stores.isEmpty()) {
                        _getCartListState.value = Failure(null)
                        Timber.e("GET STORE LIST FAIL : EMPTY!!!")
                        return@onSuccess
                    }
                    _storeList.value = stores
                    _getCartListState.value = Success
                    Timber.d("GET STORE LIST SUCCESS : $stores")
                }
                .onFailure { t ->
                    if (t is HttpException) {
                        _getCartListState.value = Error
                        Timber.e("GET STORE LIST FAIL ${t.code()} : ${t.message}}")
                    }
                }
        }
    }

    private suspend fun getStoreListResult(): Result<List<Store>> = runCatching {
        cartService.getStoreList().stores
    }

    private fun postCartItem() {
        viewModelScope.launch {
            postCartItemResult()
                .onSuccess { response ->
                    Timber.d("POST STORE ITEM SUCCESS")
                    Timber.d("${response.status} ${response.success} ${response.message}")
                }
                .onFailure { t ->
                    if (t is HttpException) {
                        Timber.e("POST STORE ITEM FAIL ${t.code()} : ${t.message}}")
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
}
