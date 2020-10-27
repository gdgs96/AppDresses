package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appdresses.R

class order2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order2)
    }
    fun btnfo2_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }
    fun btn_sig(view: View){
        startActivity(Intent(this, order3Activity::class.java))
    }
}
