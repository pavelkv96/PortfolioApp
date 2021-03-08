package com.github.pavelkv96.portfolioapp.cv

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R

class CVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTV: TextView = itemView.findViewById(R.id.item_cv_title)
    private val descriptionTV: TextView = itemView.findViewById(R.id.item_cv_desc)

    fun bind(item: CVItem) {
        titleTV.text = item.title
        descriptionTV.text = item.description
    }
}