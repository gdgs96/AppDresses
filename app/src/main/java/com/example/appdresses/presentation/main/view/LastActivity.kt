package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_last.*

class LastActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)
        val t_Anticipo= findViewById<TextView>(R.id.txtNumberDecimal2)
        val t_Precio= findViewById<TextView>(R.id.txtNumberDecimal3)
        val t_Total= findViewById<TextView>(R.id.txtNumberDecimal)
        val t_TotalT= findViewById<TextView>(R.id.txtNumberDecimal4)

        auth= FirebaseAuth.getInstance()
        var currentUser = auth.currentUser
        val nom = intent.getStringExtra("nom")
        //Activity donde se obtienen los datos de pago y se da baja al pedido
        db.collection(currentUser?.email.toString()).document(nom!!).get().addOnSuccessListener {
            val tAnticipo = it.getString("etAnticipo")?.toInt()
            val tPrecio = it.getString("etPrecio")?.toInt()
            var debe:Int=0
            debe = tPrecio!! - tAnticipo!!
            t_Anticipo.setText("$$tAnticipo")
            t_Precio.setText("$$debe")
            t_Total.setText("$$tPrecio")
            t_TotalT.setText("-$$debe")
        }
        btnPaynow.setOnClickListener{
            db.collection(currentUser?.email.toString()).document(nom).delete()
            startActivity(Intent(this, MainActivityNav::class.java))
        }
    }
    fun regresar(view: View){
        onBackPressed()
    }
    fun decline(view: View){
        onBackPressed()
    }
}
