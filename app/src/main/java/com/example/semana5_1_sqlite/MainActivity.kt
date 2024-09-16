package com.example.semana5_1_sqlite

import Beans.Usuarios
import Persistencia.OpenHelper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper:OpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtNom:EditText=findViewById(R.id.txtNombre)
        val txtEdad:EditText=findViewById(R.id.txtEdad)
        val txtCorreo:EditText=findViewById(R.id.txtCorreo)

        val btnGrabar:Button=findViewById(R.id.btnGrabar)

        btnGrabar.setOnClickListener(){

            dbHelper= OpenHelper(this)

            val u=Usuarios(
                txtNom.text.toString(),
                txtEdad.text.toString().toInt(),
                txtCorreo.text.toString()
            )

            dbHelper.nuevoUser(u)

            txtNom.text.clear()
            txtEdad.text.clear()
            txtCorreo.text.clear()

        }

        val btnListar:Button=findViewById(R.id.btnListar)

        btnListar.setOnClickListener(){
            val Intent=Intent(this, MainActivity2::class.java)
            startActivity(Intent)
        }

        val btnAcciones:Button=findViewById(R.id.btnEliminarEditar)
        val linear:LinearLayout=findViewById(R.id.lnAcciones)

        btnAcciones.setOnClickListener(){
            if(linear.visibility== View.VISIBLE){
                linear.visibility=View.INVISIBLE
            }else{
                linear.visibility=View.VISIBLE
            }
        }

        val btnEliminar:Button=findViewById(R.id.btnEliminar)
        val btnEditar:Button=findViewById(R.id.btnEditar)
        val txtAccion:EditText=findViewById(R.id.txtAccion)

        btnEliminar.setOnClickListener(){

            dbHelper=OpenHelper(this)

            dbHelper.deleteData(txtAccion.text.toString().toInt())
            txtAccion.text.clear()

        }

        btnEditar.setOnClickListener(){
            dbHelper=OpenHelper(this)

            val u=Usuarios(txtAccion.text.toString().toInt(),
                txtNom.text.toString(),
                txtEdad.text.toString().toInt(),
                txtCorreo.text.toString())

            dbHelper.updateData(u)
            txtAccion.text.clear()

        }


    }
}