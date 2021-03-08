package com.github.pavelkv96.portfolioapp.team

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.pavelkv96.portfolioapp.R

class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTV: TextView = itemView.findViewById(R.id.team_item_name)
    private val descTV: TextView = itemView.findViewById(R.id.team_item_desc)
    private val imageIV: ImageView = itemView.findViewById(R.id.team_item_img)

    fun bind(item: TeamItem) {
        Glide.with(itemView).clear(imageIV)
        nameTV.text = item.name
        descTV.text = item.description
        Glide.with(itemView).load(item.image).into(imageIV)
    }
}