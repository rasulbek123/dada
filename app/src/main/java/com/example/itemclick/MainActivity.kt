package com.example.itemclick

import android.content.Intent
import android.media.audiofx.AudioEffect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*

class MainActivity : AppCompatActivity() {
    var adapter:ListViewAdapter = ListViewAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL))
        adapter.onItemClick = {
            val intent = Intent(this,SecondActivity ::class.java)
            intent.putExtra("Item" , userName.text)
            startActivity(intent)
        }
        setData()
    }
    fun setData(){
        var models:MutableList<User> = mutableListOf()
        for(i in 1 .. 1000){
            var model:User =User()
            model.Name = "My name is...${i}"
            model.LastName = "My lastname is ...${i}"
            models.add(model)
        }
        adapter.models = models
    }

}