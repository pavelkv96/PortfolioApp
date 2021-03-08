package com.github.pavelkv96.portfolioapp.cv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R

class CVAdapter : ListAdapter<CVItem, CVViewHolder>(CVItemItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cv, parent, false)
        return CVViewHolder(view)
    }

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun getItem(position: Int): CVItem? = currentList.getOrNull(position)
}