package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_order3.*
import java.io.Serializable



class order3Activity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order3)
        auth= FirebaseAuth.getInstance()
        var Bundle=intent.extras
        val tMama = intent.getStringExtra("tMama")
        val id = intent.getStringExtra("id")
        val fPedido = intent.getStringExtra("fPedido")
        val fEvento = intent.getStringExtra("fEvento")
        val tPruebas = intent.getStringExtra("tPruebas")
        val tPruebas2 = intent.getStringExtra("tPruebas2")
        val tTelefono = intent.getStringExtra("tTelefono")
        val tColor = intent.getStringExtra("tColor")
        val tAnticipo = intent.getStringExtra("tAnticipo")
        val tPrecio = intent.getStringExtra("tPrecio")
        val tPinBusto = intent.getStringExtra("tPinBusto")
        val tDisBusto = intent.getStringExtra("tDisBusto")
        val tBusto = intent.getStringExtra("tBusto")
        val tFrente = intent.getStringExtra("tFrente")
        val tEspalda = intent.getStringExtra("tEspalda")
        val tCintura = intent.getStringExtra("tCintura")
        val tTallaF = intent.getStringExtra("tTallaF")
        val tTallaE = intent.getStringExtra("tTallaE")
        val tCadera = intent.getStringExtra("tCadera")
        val tLarFal = intent.getStringExtra("tLarFal")
        val tLarMan = intent.getStringExtra("tLarMan")
        val tPunAlto = intent.getStringExtra("tPunAlto")
        val tPunBajo = intent.getStringExtra("tPunBajo")
        /*val map1 = intent.getSerializableExtra("map1")
        val map2 = intent.getSerializableExtra("map2")*/
        var currentUser = auth.currentUser

        btnfin.setOnClickListener{
            /*db.document(id!!).collection(currentUser?.email.toString())
                .add(map1)
            db.document(id).collection(currentUser?.email.toString())
                .add(map2)*/
            auth= FirebaseAuth.getInstance()
            var order = hashMapOf("nombreMama" to tMama,
                "editT_nom" to id,
                "etF_Pedido" to fPedido,
                "etF_Evento" to fEvento,
                "etPruebas" to tPruebas,
                "etPruebas2" to tPruebas2,
                "etTelefono" to tTelefono,
                "etColor" to tColor,
                "etAnticipo" to tAnticipo,
                "etPrecio" to tPrecio,
                "etPinBusto" to tPinBusto,
                "etDisBusto" to tDisBusto,
                "etBusto" to tBusto,
                "etFrente" to tFrente,
                "etEspalda" to tEspalda,
                "etCintura" to tCintura,
                "etTallaF" to tTallaF,
                "etTallaE" to tTallaE,
                "etCadera" to tCadera,
                "etLarFal" to tLarFal,
                "etLarMan" to tLarMan,
                "etPunAlto" to tPunAlto,
                "etPunBajo" to tPunBajo,
                "etCaract" to etCaract.text.toString(),
                "etTelas" to etTelas.text.toString())
            println(order)
            db.collection(currentUser?.email.toString()).document(id!!)
                //.collection("Order 3").document("Order 3")
                .set(order)
            action()
        }

    }
    fun btnfo2_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }

    fun action(){
        startActivity(Intent(this, MainActivityNav::class.java))
    }

}


