package com.example.appdresses.presentation.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appdresses.R
import com.example.appdresses.presentation.main.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*
import org.jetbrains.anko.support.v4.pagerTitleStrip

class MainActivityNav : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var email: TextView
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navmain)
        val email= findViewById<TextView>(R.id.email_cuenta)
        auth= FirebaseAuth.getInstance()
        var currentUser = auth.currentUser
        /*Recibe los datos de otra activitie
        val objetoIntent: Intent=intent
        var user = objetoIntent.getStringExtra("Email")*/
        email.setText(currentUser?.email.toString());

        print(currentUser?.email.toString())
        db.collection(currentUser?.email.toString()).get().addOnSuccessListener{ result->
                for (document in result){
                    //println(query.id)
                    val nom = document.getString("editT_nom")
                    val tel = document.getString("etTelefono")
                    val event = document.getString("etF_Evento")
                    println("Nombre:$nom,Telefono:$tel,Fecha de evento:$event")
                }
        }
    }

    fun boton(view: View){
        startActivity(Intent(this, orderActivity::class.java))
    }

    fun salir(view: View){
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}

