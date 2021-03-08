package com.github.pavelkv96.portfolioapp.portfolio

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.github.pavelkv96.portfolioapp.R

class PortfolioViewHolder(
        itemView: View,
        listener: (Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val imagePortfolio: ImageView = itemView.findViewById(R.id.item_portfolio_img)

    init {
        itemView.setOnClickListener { listener.invoke(adapterPosition) }
    }

    fun bind(item: PortfolioItem) {
        Glide.with(itemView).clear(imagePortfolio)
        Glide.with(itemView).load(item.image).into(imagePortfolio)
    }
}