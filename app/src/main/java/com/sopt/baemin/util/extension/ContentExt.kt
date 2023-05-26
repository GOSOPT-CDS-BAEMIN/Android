package com.sopt.baemin.util.extension

import android.view.View
import com.sopt.baemin.util.OnSingleClickListener

fun View.setSingleOnClickListener(onSingleClick: (View) -> Unit) {
    setOnClickListener(OnSingleClickListener { onSingleClick(it) })
}
