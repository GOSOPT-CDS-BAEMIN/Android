package com.sopt.baemin.presentation.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sopt.baemin.R

class BottomSheetActivity(context: Context): BottomSheetDialogFragment() {
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
}