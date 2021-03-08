package com.github.pavelkv96.portfolioapp.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R
import java.util.*

class PortfolioFragment : Fragment(), (Int) -> Unit {

    private var portfolioData: MutableList<PortfolioItem>? = null
    private var portfolioList: RecyclerView? = null
    private var portfolioAdapter: PortfolioAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        portfolioData = mutableListOf()

        portfolioData?.apply {
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project7))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project3))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project5))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project5))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project0))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project2))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project3))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project7))
            add(PortfolioItem("Project Name", getString(R.string.lorem_text), R.drawable.project1))
            portfolioAdapter = PortfolioAdapter(this, this@PortfolioFragment)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        portfolioList = view.findViewById(R.id.rv_portfolio)

        portfolioList?.apply {
            layoutManager = GridLayoutManager(activity, 3)
            setHasFixedSize(true)
            adapter = portfolioAdapter
        }
    }

    override fun invoke(positon: Int) {
        portfolioData?.let {
            val portfolioFragmentDetails = PortfolioFragmentDetails.newInstance(it[positon])
            portfolioFragmentDetails.show(requireActivity().supportFragmentManager, "PortfolioDetailsFragment")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): PortfolioFragment = PortfolioFragment().also { it.arguments = Bundle().apply {  } }
    }
}