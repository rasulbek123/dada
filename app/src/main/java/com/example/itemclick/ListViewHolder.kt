package com.example.itemclick

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    private var userName:TextView = itemView.userName
    private var lastName:TextView = itemView.userLastname
    fun populeatmodel(user: User,onItemClick:(user:User)->Unit){
        userName.text = user.Name
        lastName.text = user.LastName
        itemView.setOnClickListener {
            onItemClick.invoke(user)
        }
    }
}