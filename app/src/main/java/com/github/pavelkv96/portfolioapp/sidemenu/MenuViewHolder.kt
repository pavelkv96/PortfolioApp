package com.github.pavelkv96.portfolioapp.sidemenu

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.pavelkv96.portfolioapp.R

class MenuViewHolder(itemView: View, listener: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val icon: ImageView = itemView.findViewById(R.id.item_menu_icon)
    private val isSelected: ImageView = itemView.findViewById(R.id.item_menu_selected)

    init {
        itemView.setOnClickListener { listener.invoke(adapterPosition) }
    }

    fun bind(item: MenuItem) {
        Glide.with(itemView).load(item.icon).into(icon)
        if (item.isSelected) isSelected.visibility = View.VISIBLE else isSelected.visibility = View.GONE
    }
}