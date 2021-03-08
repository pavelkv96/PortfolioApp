package com.github.pavelkv96.portfolioapp.sidemenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R

class MenuAdapter(
        private val mData: List<MenuItem>,
        private val listener: (Int) -> Unit
) : RecyclerView.Adapter<MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        mData.getOrNull(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = mData.size
}