package com.github.pavelkv96.portfolioapp.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R

class PortfolioAdapter(
        private val listData: List<PortfolioItem>,
        private val listener: (Int) -> Unit
) : RecyclerView.Adapter<PortfolioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_portfolio, parent, false)
        return PortfolioViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        listData.getOrNull(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = listData.size
}