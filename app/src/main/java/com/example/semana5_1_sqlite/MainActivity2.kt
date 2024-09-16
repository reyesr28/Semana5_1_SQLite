package com.example.semana5_1_sqlite

import Persistencia.OpenHelper
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    lateinit var dbHelper:OpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getUserAll()
    }

    private fun getUserAll(){
        dbHelper=OpenHelper(this)
        var data=dbHelper.leerData()

        val recyler=findViewById<RecyclerView>(R.id.recyclerUser)
        recyler.layoutManager=LinearLayoutManager(applicationContext)
        recyler.adapter=Adapter(data)

    }

}