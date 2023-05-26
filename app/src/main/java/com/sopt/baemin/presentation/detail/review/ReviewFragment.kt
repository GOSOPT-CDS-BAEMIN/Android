package com.sopt.baemin.presentation.detail.review

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.baemin.R
import com.sopt.baemin.databinding.FragmentReviewBinding
import com.sopt.baemin.presentation.detail.DetailViewModel
import com.sopt.baemin.util.binding.BindingFragment
import com.sopt.baemin.util.extension.setSingleOnClickListener

class ReviewFragment : BindingFragment<FragmentReviewBinding>(R.layout.fragment_review) {
    private val viewModel: DetailViewModel by viewModels()
    private val reviewAdapter: ReviewAdapter = ReviewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
        initAdapter()
        initObserve()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getReview(1)
    }

    private fun initAdapter() {
        binding.rvDetailReview.adapter = reviewAdapter
    }

    private fun initObserve() {
        viewModel.reviewInfo.observe(viewLifecycleOwner) {
            reviewAdapter.submitList(it.data.toMutableList())
            Log.d("asdf", it.data.toString())
        }
    }

    private fun initReviewFilterBtnClickListener() {
        binding.ivDetailReviewFilter.setSingleOnClickListener {
            // startActivity(Intent(requireActivity(), 주영언니바텀시트::class.java))
        }
    }
}
