package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    var Usuario: TextView?=null
    var Pass: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val btnVolver:Button = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener { onClickVolver() }
        iniciarComponentes()
        cargarDatos()
    }

    private fun iniciarComponentes() {
        Usuario=findViewById(R.id.txtName)
        Pass=findViewById(R.id.txtPass)
    }

    private fun cargarDatos() {
        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var usuario: String? =preferences.getString("user","No existe la información")
        var pass: String? =preferences.getString("pass","No existe la información")

        Usuario?.text=usuario
        Pass?.text=pass
    }

    private fun onClickVolver(){
        finish()
    }
}

