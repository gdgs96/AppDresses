package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_order.*

class orderActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        //Con esto se obtiene los datos del logeo
        auth= FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        saveButton.setOnClickListener(){
            startActivity(Intent(this, order2Activity::class.java))
            db.collection("Users").document(currentUser?.email.toString()).set(
                hashMapOf("nombreMama" to editT_mama.text.toString(),
                "editT_nom" to editT_nom.text.toString(),
                "etF_Pedido" to etF_Pedido.text.toString(),
                "etF_Evento" to etF_Evento.text.toString(),
                "etPruebas" to etPruebas.text.toString(),
                "etPruebas2" to etPruebas2.text.toString(),
                "etTelefono" to etTelefono.text.toString(),
                "etColor" to etColor.text.toString(),
                "etAnticipo" to etAnticipo.text.toString(),
                "etPrecio" to etPrecio.text.toString())
            )
        }

    }

    fun btnfo_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }
}
