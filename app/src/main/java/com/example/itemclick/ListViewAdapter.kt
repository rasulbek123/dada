package com.example.itemclick

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListViewAdapter():RecyclerView.Adapter<ListViewHolder>() {
    var models :List<User> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    var onItemClick:(user:User) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
       return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populeatmodel(models[position],onItemClick)
    }

    override fun getItemCount(): Int {
        return models.size
    }
}