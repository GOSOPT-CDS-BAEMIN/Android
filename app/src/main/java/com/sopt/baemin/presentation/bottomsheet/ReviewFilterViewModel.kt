package com.sopt.baemin.presentation.bottomsheet

import androidx.lifecycle.ViewModel

class ReviewFilterViewModel : ViewModel() {

    val mockBottomSheetData = listOf<BottomSheetData>(
        BottomSheetData(
            food_name1 = "[신선] 육회비빔밥",
            food_name2 = "[신선] 육회비빔밥",
            food_name3 = "[신선]낙지 비빔냉면",
        )
    )

}