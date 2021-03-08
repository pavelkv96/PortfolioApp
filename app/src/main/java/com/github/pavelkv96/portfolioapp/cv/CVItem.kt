package com.github.pavelkv96.portfolioapp.cv

import androidx.recyclerview.widget.DiffUtil

class CVItem(val id: Int, val title: String, val description: String)
object CVItemItemCallback : DiffUtil.ItemCallback<CVItem>() {
    override fun areItemsTheSame(oldItem: CVItem, newItem: CVItem): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CVItem, newItem: CVItem): Boolean = oldItem.id == newItem.id
}