package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_order3.*

class order3Activity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order3)
        auth= FirebaseAuth.getInstance()
        var Bundle=intent.extras
        val id = intent.getStringExtra("id")
        val map1 = intent.getSerializableExtra("map1")
        val map2 = intent.getSerializableExtra("map2")
        var currentUser = auth.currentUser

        btnfin.setOnClickListener{
            db.collection(currentUser?.email.toString()).document(id!!)
                .collection("Order 1").document("Order 1")
                .set(map1)
            db.collection(currentUser?.email.toString()).document(id)
                .collection("Order 2").document("Order 2")
                .set(map2)
            action(id)
        }

    }
    fun btnfo2_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }

    fun action(id:String?){
        auth= FirebaseAuth.getInstance()
        var order3 = hashMapOf("etCaract" to etCaract.text.toString(), "etTelas" to etTelas.text.toString())
        var currentUser = auth.currentUser
        println(currentUser)
        db.collection(currentUser?.email.toString()).document(id!!)
            .collection("Order 3").document("Order 3")
            .set(order3)

        startActivity(Intent(this, MainActivityNav::class.java))
    }
}
