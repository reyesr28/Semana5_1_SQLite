package com.example.semana5_1_sqlite

import Beans.Usuarios
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class userViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val userId=view.findViewById<TextView>(R.id.txtCardId)
    val userNom=view.findViewById<TextView>(R.id.txtCardNombre)
    val userEdad=view.findViewById<TextView>(R.id.txtCardEdad)
    val userCorreo=view.findViewById<TextView>(R.id.txtCardCorreo)

    fun render(userModel:Usuarios){
        userId.text=userModel.cod.toString()
        userNom.text=userModel.nombre
        userEdad.text=userModel.edad.toString()
        userCorreo.text=userModel.mail
    }

}