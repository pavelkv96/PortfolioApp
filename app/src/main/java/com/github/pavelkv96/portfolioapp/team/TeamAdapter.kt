package com.github.pavelkv96.portfolioapp.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R

class TeamAdapter(private val list: List<TeamItem>) : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        list.getOrNull(position)?.also { holder.bind(it) }
    }

    override fun getItemCount(): Int = list.size
}