package com.github.pavelkv96.portfolioapp.cv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R

class CVFragment : Fragment() {
    private var listRV: RecyclerView? = null
    private var cvAdapter: CVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cvAdapter = CVAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listRV = view.findViewById(R.id.recyclerview_cv)

        // create a list of cv items
        val items = mutableListOf<CVItem>()
        items.apply {
            add(CVItem(1, "20 April 2013", getString(R.string.lorem_text)))
            add(CVItem(2, "20 May 2013", getString(R.string.lorem_text2)))
            add(CVItem(3, "25 July 2013", getString(R.string.lorem_text)))
            add(CVItem(4, "20 April 2013", getString(R.string.lorem_text2)))
        }

        cvAdapter?.submitList(items)
        listRV?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = cvAdapter
        }
    }

    override fun onDestroyView() {
        listRV?.adapter = null
        listRV?.layoutManager = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        cvAdapter = null
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance(): CVFragment {
            return CVFragment().also {
                it.arguments = Bundle().apply {

                }
            }
        }
    }
}