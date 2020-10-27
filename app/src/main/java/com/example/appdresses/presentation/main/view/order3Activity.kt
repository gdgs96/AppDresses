package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appdresses.R

class order3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order3)
    }
    fun btnfo2_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }
    fun btn_fin(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }
}
