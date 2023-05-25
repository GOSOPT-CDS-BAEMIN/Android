package com.sopt.baemin.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.sopt.baemin.R

@BindingAdapter("setRoundedCornersImage")
fun ImageView.setRoundedCornersImage(imgUrl: String?) {
    load(imgUrl) {
        placeholder(R.drawable.ic_img_loading)
        error(R.drawable.ic_img_loading_error)
        fallback(R.drawable.ic_img_loading_error)
        transformations(RoundedCornersTransformation(30f))
    }
}