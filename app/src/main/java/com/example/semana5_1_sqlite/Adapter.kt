package com.example.semana5_1_sqlite

import Beans.Usuarios
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(val userList:List<Usuarios>):RecyclerView.Adapter<userViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {

        val layoutInflater=LayoutInflater.from(parent.context)
        return userViewHolder(layoutInflater.inflate(R.layout.card,parent,false))

    }

    override fun getItemCount(): Int =userList.size

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val item=userList[position]
        holder.render(item)
    }

}