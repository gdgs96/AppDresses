package com.example.appdresses.presentation.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.appdresses.R

class MainActivityNav : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navmain)

    }

    fun boton(view: View){
        startActivity(Intent(this, orderActivity::class.java))
    }
}