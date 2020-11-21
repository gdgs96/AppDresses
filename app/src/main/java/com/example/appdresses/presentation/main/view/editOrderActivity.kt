package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_edit_order.*

class editOrderActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_order)
        val editTmama= findViewById<EditText>(R.id.editT_mama)
        val editTnom= findViewById<EditText>(R.id.editT_nom)
        val etFPedido= findViewById<EditText>(R.id.etF_Pedido)
        val etFEvento= findViewById<EditText>(R.id.etF_Evento)
        val tPruebas= findViewById<EditText>(R.id.etPruebas)
        val tPruebas2= findViewById<EditText>(R.id.etPruebas2)
        val tTelefono= findViewById<EditText>(R.id.etTelefono)
        val tColor= findViewById<EditText>(R.id.etColor)
        val tAnticipo= findViewById<EditText>(R.id.etAnticipo)
        val tPrecio= findViewById<EditText>(R.id.etPrecio)
        val tPinBusto= findViewById<EditText>(R.id.etPinBusto)
        val tDisBusto= findViewById<EditText>(R.id.etDisBusto)
        val tBusto= findViewById<EditText>(R.id.etBusto)
        val tFrente= findViewById<EditText>(R.id.etFrente)
        val tEspalda= findViewById<EditText>(R.id.etEspalda)
        val tCintura= findViewById<EditText>(R.id.etCintura)
        val tTallaF= findViewById<EditText>(R.id.etTallaF)
        val tTallaE= findViewById<EditText>(R.id.etTallaE)
        val tCadera= findViewById<EditText>(R.id.etCadera)
        val tLarFal= findViewById<EditText>(R.id.etLarFal)
        val tLarMan= findViewById<EditText>(R.id.etLarMan)
        val tPunAlto= findViewById<EditText>(R.id.etPunAlto)
        val tPunBajo= findViewById<EditText>(R.id.etPunBajo)
        val tCaract= findViewById<EditText>(R.id.etCaract)
        val tTelas= findViewById<EditText>(R.id.etTelas)


        auth= FirebaseAuth.getInstance()
        var currentUser = auth.currentUser
        var nom = intent.getStringExtra("nom")

        db.collection(currentUser?.email.toString()).document(nom).get().addOnSuccessListener {
            editTmama.setText(it.get("nombreMama") as String?)
            editTnom.setText(it.get("editT_nom") as String?)
            etFPedido.setText(it.get("etF_Pedido") as String?)
            etFEvento.setText(it.get("etF_Evento") as String?)
            tPruebas.setText(it.get("etPruebas") as String?)
            tPruebas2.setText(it.get("etPruebas2") as String?)
            tTelefono.setText(it.get("etTelefono") as String?)
            tColor.setText(it.get("etColor") as String?)
            tAnticipo.setText(it.get("etAnticipo") as String?)
            tPrecio.setText(it.get("etPrecio") as String?)
            tPinBusto.setText(it.get("etPinBusto") as String?)
            tDisBusto.setText(it.get("etDisBusto") as String?)
            tBusto.setText(it.get("etBusto") as String?)
            tFrente.setText(it.get("etFrente") as String?)
            tEspalda.setText(it.get("etEspalda") as String?)
            tCintura.setText(it.get("etCintura") as String?)
            tTallaF.setText(it.get("etTallaF") as String?)
            tTallaE.setText(it.get("etTallaE") as String?)
            tCadera.setText(it.get("etCadera") as String?)
            tLarFal.setText(it.get("etLarFal") as String?)
            tLarMan.setText(it.get("etLarMan") as String?)
            tPunAlto.setText(it.get("etPunAlto") as String?)
            tPunBajo.setText(it.get("etPunBajo") as String?)
            tCaract.setText(it.get("etCaract") as String?)
            tTelas.setText(it.get("etTelas") as String?)
        }
        //Activity donde edita los datos del cliente y los guarda en la base de datos
        saveButton.setOnClickListener{
            var order = hashMapOf("nombreMama" to editT_mama.text.toString(),
                "editT_nom" to editT_nom.text.toString(),
                "etF_Pedido" to etF_Pedido.text.toString(),
                "etF_Evento" to etF_Evento.text.toString(),
                "etPruebas" to etPruebas.text.toString(),
                "etPruebas2" to etPruebas2.text.toString(),
                "etTelefono" to etTelefono.text.toString(),
                "etColor" to etColor.text.toString(),
                "etAnticipo" to etAnticipo.text.toString(),
                "etPrecio" to etPrecio.text.toString(),
                "etPinBusto" to etPinBusto.text.toString(),
                "etDisBusto" to etDisBusto.text.toString(),
                "etBusto" to etBusto.text.toString(),
                "etFrente" to etFrente.text.toString(),
                "etEspalda" to etEspalda.text.toString(),
                "etCintura" to etCintura.text.toString(),
                "etTallaF" to etTallaF.text.toString(),
                "etTallaE" to etTallaE.text.toString(),
                "etCadera" to etCadera.text.toString(),
                "etLarFal" to etLarFal.text.toString(),
                "etLarMan" to etLarMan.text.toString(),
                "etPunAlto" to etPunAlto.text.toString(),
                "etPunBajo" to etPunBajo.text.toString(),
                "etCaract" to etCaract.text.toString(),
                "etTelas" to etTelas.text.toString())
            nom = editT_nom.text.toString()
            db.collection(currentUser?.email.toString()).document(nom!!)
                .set(order)
            var intent = Intent(this, progressOrderActivity::class.java)
            val a : Bundle = Bundle()
            a.putString("nom",nom)
            intent.putExtras(a)
            startActivity(intent)
        }
    }
    fun btnfo_back(view: View){
        onBackPressed()
    }
}
