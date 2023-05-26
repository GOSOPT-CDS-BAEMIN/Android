package com.sopt.baemin.presentation.bottomsheet

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sopt.baemin.R
import com.sopt.baemin.data.api.ApiFactory
import com.sopt.baemin.databinding.ActivityReviewFilterBinding

class BottomSheetActivity(context: Context): BottomSheetDialogFragment() {
    private val foodService = ApiFactory.ServicePool.foodListReviewService
    private var _binding: ActivityReviewFilterBinding? = null
    val binding : ActivityReviewFilterBinding
        get() = requireNotNull(_binding) { "이렇게 쓰면 안됩니다~" }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.activity_review_filter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.findViewById<Button>(R.id.btn_show_review)?.setOnClickListener{
            Toast.makeText(context, getString(R.string.init_review),Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    fun init(){
        val response = foodService.getFoodListReview()
        if (response.isSuccessful) {
            val result = response.body()
            with(binding) {
                tvMenu1.text = response.body()?.data?.foods?.get(0)?.foodName
                tvMenu2.text = response.body()?.data?.foods?.get(0)?.foodName
                tvMenu3.text = response.body()?.data?.foods?.get(0)?.foodName
            }
        }
        else{
            Log.d("서버 통신 오류","서버오류")
        }
    }
}