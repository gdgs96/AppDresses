package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_order.*

class orderActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth
    private lateinit var editT_mama:EditText
    private lateinit var editT_nom:EditText
    private lateinit var etF_Pedido:EditText
    private lateinit var etF_Evento:EditText
    private lateinit var etPruebas:EditText
    private lateinit var etPruebas2:EditText
    private lateinit var etTelefono:EditText
    private lateinit var etColor:EditText
    private lateinit var etAnticipo:EditText
    private lateinit var etPrecio:EditText

    lateinit var tNom:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        editT_mama=findViewById(R.id.editT_mama)
        editT_nom=findViewById(R.id.editT_nom)
        etF_Pedido=findViewById(R.id.etF_Pedido)
        etF_Evento=findViewById(R.id.etF_Evento)
        etPruebas=findViewById(R.id.etPruebas)
        etPruebas2=findViewById(R.id.etPruebas2)
        etTelefono=findViewById(R.id.etTelefono)
        etColor=findViewById(R.id.etColor)
        etAnticipo=findViewById(R.id.etAnticipo)
        etPrecio=findViewById(R.id.etPrecio)
        auth= FirebaseAuth.getInstance()
        //Con esto se obtiene los datos del logeo

        var currentUser = auth.currentUser
        println(currentUser)
        val a : Bundle = Bundle()
        a.putString("email", currentUser.toString())
        intent.putExtras(a)

        saveButton.setOnClickListener {
            validateText()
            // Con esto se tomaran los datos pero se deben tomar hasta el final de la 3era


        }

    }

    fun action(){

        var intent = Intent(this, order2Activity::class.java)
        var order1 = hashMapOf("nombreMama" to editT_mama.text.toString(),
            "editT_nom" to editT_nom.text.toString(),
            "etF_Pedido" to etF_Pedido.text.toString(),
            "etF_Evento" to etF_Evento.text.toString(),
            "etPruebas" to etPruebas.text.toString(),
            "etPruebas2" to etPruebas2.text.toString(),
            "etTelefono" to etTelefono.text.toString(),
            "etColor" to etColor.text.toString(),
            "etAnticipo" to etAnticipo.text.toString(),
            "etPrecio" to etPrecio.text.toString())
        tNom=editT_nom.text.toString()

        val a : Bundle = Bundle()
        val c : Bundle = Bundle()
        val b : Bundle = Bundle()
        c.putString("id",tNom)
        b.putSerializable("map1",order1)
        intent.putExtras(b)
        intent.putExtras(c)



        /*db.collection(currentUser?.email.toString()).document(tNom)
            .collection("Order 1").document("Order 1")
            .set(order1)*/
        startActivity(intent)
    }

    fun btnfo_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }

    private fun validateText(){
        val nameM = editT_mama.text.toString()
        val nom = editT_nom.text.toString()
        val fechaPed = etF_Pedido.text.toString()
        val fechaEve = etF_Evento.text.toString()
        val fechaPr = etPruebas.text.toString()
        val fechaPr2 = etPruebas2.text.toString()
        val tel = etTelefono.text.toString()
        val col = etColor.text.toString()
        val anticipo = etAnticipo.text.toString()
        val precio = etPrecio.text.toString()

        if (!TextUtils.isEmpty(nameM) && !TextUtils.isEmpty(nom) && !TextUtils.isEmpty(fechaPed) && !TextUtils.isEmpty(fechaEve) && !TextUtils.isEmpty(fechaPr) && !TextUtils.isEmpty(fechaPr2) &&
            !TextUtils.isEmpty(tel) && !TextUtils.isEmpty(col) && !TextUtils.isEmpty(anticipo) && !TextUtils.isEmpty(precio)){
            action()
        }
        if(TextUtils.isEmpty(nameM)){
            editT_mama.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(nom)){
            editT_nom.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(fechaPed)){
            etF_Pedido.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(fechaEve)){
            etF_Evento.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(fechaPr)){
            etPruebas.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(fechaPr2)){
            etPruebas2.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(tel)){
            etTelefono.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(col)){
            etColor.error = "No se ha llenado este campo"
            return
        }
        if(TextUtils.isEmpty(anticipo)){
            etAnticipo.error = "No se ha llenado este campo"
            return
        }
        if(!TextUtils.isEmpty(precio)){
            etPrecio.error = "No se ha llenado este campo"
            return
        }
    }
}


