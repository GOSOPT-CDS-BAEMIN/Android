package com.sopt.baemin.presentation.bottomsheet

import android.os.Bundle
import com.sopt.baemin.R
import com.sopt.baemin.databinding.ActivityShowReviewBinding
import com.sopt.baemin.util.binding.BindingActivity

class InitBottomSheetActivity : BindingActivity<ActivityShowReviewBinding>(R.layout.activity_show_review) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnBottomsheetShow.setOnClickListener{
            val bottomSheet = BottomSheetActivity(this)
            bottomSheet.show(supportFragmentManager,bottomSheet.tag)
        }

    }
}