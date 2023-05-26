package com.sopt.baemin.util.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/** Make a Snackbar to display a message */
fun Context.showSnackbar(view: View, msg: String) {
    Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
}

/** Make a Toast to display a message */
fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}