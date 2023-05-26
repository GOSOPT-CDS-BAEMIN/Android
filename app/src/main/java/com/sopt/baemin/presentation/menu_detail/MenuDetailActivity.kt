package com.sopt.baemin.presentation.menu_detail

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sopt.baemin.R
import com.sopt.baemin.data.api.ApiFactory
import com.sopt.baemin.data.model.response.ResponseGetMenuDetailDto
import com.sopt.baemin.databinding.ActivityMenuDetailBinding
import com.sopt.baemin.util.binding.BindingActivity
import retrofit2.Call
import retrofit2.Response

class MenuDetailActivity : BindingActivity<ActivityMenuDetailBinding>(R.layout.activity_menu_detail) {
    private val menuDetailService = ApiFactory.ServicePool.menuDetailService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("이건 되나","제발 좀 되라")
        init()
    }

    private fun init(){
        Log.e("함수 진입","함수 진입")
        menuDetailService.getMenuDetail().enqueue(object: retrofit2.Callback<ResponseGetMenuDetailDto>{
            override fun onResponse(
                call: Call<ResponseGetMenuDetailDto>,
                response: Response<ResponseGetMenuDetailDto>
            ) {
                if(response.isSuccessful){
                    Log.e("서버 통신","response 성공")
                    with(binding){
                        tvMenuName.text = response.body()?.data?.foodName
                        tvPrice.text = response.body()?.data?.price.toString()
                        tvFoodDescription.text=response.body()?.data?.foodDescription
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetMenuDetailDto>, t: Throwable) {
                t.message?.let{ Toast.makeText(this@MenuDetailActivity, "서버통신 실패 응답값이 없습니다.", Toast.LENGTH_SHORT)}
            }

        })
    }
}