package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_progress_order.*

class progressOrderActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_order)
        val mama_nom= findViewById<TextView>(R.id.nom_Mama)
        val nom_C= findViewById<TextView>(R.id.nom)
        val t_Pedido= findViewById<TextView>(R.id.tPedido)
        val t_evento= findViewById<TextView>(R.id.tEvent)
        val t_pruebas= findViewById<TextView>(R.id.tPruebas)
        val t_Tel= findViewById<TextView>(R.id.tTel)
        val t_Color = findViewById<TextView>(R.id.tColor)
        val t_Anticipo= findViewById<TextView>(R.id.tAnticipo)
        val t_Precio= findViewById<TextView>(R.id.tPrecio)
        val t_Total= findViewById<TextView>(R.id.tTotal)

        auth= FirebaseAuth.getInstance()
        var currentUser = auth.currentUser

        val nom = intent.getStringExtra("nom")
        println(nom)
        //Este obtiene la base de datos de los clientes pendientes y nos da una parte de la informacion
        db.collection(currentUser?.email.toString()).document(nom!!).get().addOnSuccessListener {
            val nom_Mama = it.getString("nombreMama")
            val nomb = it.getString("editT_nom")
            val tPedido = it.getString("etF_Pedido")
            val tEvent = it.getString("etF_Evento")
            val tPruebas = it.getString("etPruebas")
            val tPruebas2 = it.getString("etPruebas2")
            val tTel = it.getString("etTelefono")
            val tColor = it.getString("etColor")
            val tAnticipo = it.getString("etAnticipo")?.toInt()
            val tPrecio = it.getString("etPrecio")?.toInt()
            var debe:Int=0
            debe = tPrecio!! - tAnticipo!!

            mama_nom.setText("Nombre de la Mama: $nom_Mama")
            nom_C.setText("Nombre: $nomb")
            t_Pedido.setText("Fecha de pedido: $tPedido")
            t_evento.setText("Fecha de evento: $tEvent")
            t_pruebas.setText("Fecha de pruebas: $tPruebas a $tPruebas2")
            t_Tel.setText("Teléfono: $tTel")
            t_Color.setText("Color del Vestido: $tColor")
            t_Anticipo.setText("Anticipo: $tAnticipo")
            t_Precio.setText("Saldo a deber: $debe")
            t_Total.setText("Precio Total: $tPrecio")
        }

        btn_Edit.setOnClickListener{
            var intent = Intent(this, editOrderActivity::class.java)
            val a : Bundle = Bundle()
            a.putString("nom",nom)
            intent.putExtras(a)
            startActivity(intent)
        }
        btn_Med.setOnClickListener{
            var intent = Intent(this, progressMedidaActivity::class.java)
            val a : Bundle = Bundle()
            a.putString("nom",nom)
            intent.putExtras(a)
            startActivity(intent)
        }
        btnfOP_buy.setOnClickListener{
            var intent = Intent(this, LastActivity::class.java)
            val a : Bundle = Bundle()
            a.putString("nom",nom)
            intent.putExtras(a)
            startActivity(intent)
        }

    }
    fun regresar(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }

}
