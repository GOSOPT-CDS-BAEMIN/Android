package com.sopt.baemin.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.baemin.data.api.ApiFactory.ServicePool.cartService
import com.sopt.baemin.data.model.response.Store
import com.sopt.baemin.util.state.RemoteUiState
import com.sopt.baemin.util.state.RemoteUiState.*
import kotlinx.coroutines.launch
import timber.log.Timber

class CartViewModel : ViewModel() {
    private val _storeList = MutableLiveData<List<Store>>()
    val storeList: List<Store>?
        get() = _storeList.value

    private val _getStoreListState = MutableLiveData<RemoteUiState>()
    val getCartListState: LiveData<RemoteUiState>
        get() = _getStoreListState
    
    init {
        getStoreList()
    }

    private suspend fun getStoreListResult(): Result<List<Store>> = runCatching {
        cartService.getStoreList(1).stores
    }

    private fun getStoreList() {
        viewModelScope.launch {
            getStoreListResult()
                .onSuccess { stores ->
                    if (stores.isEmpty()) {
                        _getStoreListState.value = Failure(null)
                        Timber.tag("RETROFIT").e("GET STORE LIST FAIL : EMPTY!!!")
                        return@onSuccess
                    }

                    _storeList.value = stores
                    _getStoreListState.value = Success
                    Timber.tag("RETROFIT").d("GET STORE LIST SUCCESS : $stores")
                }
                .onFailure { t ->
                    _getStoreListState.value = Error
                    Timber.tag("RETROFIT").e("GET STORE LIST FAIL : ${t.message}}")
                }
        }
    }
}