package com.github.pavelkv96.portfolioapp.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.github.pavelkv96.portfolioapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PortfolioFragmentDetails : BottomSheetDialogFragment() {
    private var imgPortfolio: ImageView? = null
    private var title: TextView? = null
    private var description: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgPortfolio = view.findViewById(R.id.portfolio_details_img)
        title = view.findViewById(R.id.portfolio_details_title)
        description = view.findViewById(R.id.portfolio_details_desc)

        val item = requireArguments().getSerializable("object") as PortfolioItem?
        loadPortfolioData(item)
    }

    private fun loadPortfolioData(item: PortfolioItem?) {
        item?.let {
            Glide.with(requireContext()).load(it.image).into(imgPortfolio!!)
            title?.text = it.title
            description?.text = it.description
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(portfolioData: PortfolioItem): PortfolioFragmentDetails {
            return PortfolioFragmentDetails().also {
                it.arguments = Bundle().apply { putSerializable("object", portfolioData) }
            }
        }
    }
}