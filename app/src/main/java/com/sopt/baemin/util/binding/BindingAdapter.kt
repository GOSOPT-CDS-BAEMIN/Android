package com.sopt.baemin.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.sopt.baemin.R

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("setImage")
    fun ImageView.setImage(imgUrl: String?) {
        this.let {
            Glide.with(context)
                .load(imgUrl)
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter("setCircleImage")
    fun ImageView.setCircleImage(imgUrl: String?) {
        this.let {
            Glide.with(context)
                .load(imgUrl)
                .circleCrop()
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter("setImageResource")
    fun ImageView.setImageResource(resId: Int) {
        setImageResource(resId)
    }

    @JvmStatic
    @BindingAdapter("setRoundedCornersImage")
    fun ImageView.setRoundedCornersImage(imgUrl: String?) {
        load(imgUrl) {
            placeholder(R.drawable.ic_img_loading)
            error(R.drawable.ic_img_loading_error)
            fallback(R.drawable.ic_img_loading_error)
            transformations(RoundedCornersTransformation(30f))
        }
    }
}
