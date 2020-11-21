package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.appdresses.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_progress_medida.*

class progressMedidaActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_medida)
        val tCarac= findViewById<TextView>(R.id.txt_caract)
        val tTelas= findViewById<TextView>(R.id.txt_Telas)
        val tPinBusto= findViewById<TextView>(R.id.txt_PinBusto)
        val tDisBusto= findViewById<TextView>(R.id.txt_DisBusto)
        val tBusto= findViewById<TextView>(R.id.txt_Busto)
        val tFrente= findViewById<TextView>(R.id.txt_Frente)
        val tEspalda= findViewById<TextView>(R.id.txt_Espalda)
        val tCintura= findViewById<TextView>(R.id.txt_Cintura)
        val tTallaF= findViewById<TextView>(R.id.txt_TallaF)
        val tTallaE= findViewById<TextView>(R.id.txt_TallaE)
        val tLargoF= findViewById<TextView>(R.id.txt_LargoF)
        val tLargoM= findViewById<TextView>(R.id.txt_LargoM)
        val tPunoA= findViewById<TextView>(R.id.txt_PunoA)
        val tPunoB= findViewById<TextView>(R.id.txt_PunoB)
        val TCadera= findViewById<TextView>(R.id.txt_Cadera)

        auth= FirebaseAuth.getInstance()
        var currentUser = auth.currentUser
        val nom = intent.getStringExtra("nom")

        db.collection(currentUser?.email.toString()).document(nom).get().addOnSuccessListener {
            val t_Carac = it.getString("etCaract")
            val t_Telas = it.getString("etTelas")
            val t_PinBusto = it.getString("etPinBusto")
            val t_DisBusto = it.getString("etDisBusto")
            val t_Busto = it.getString("etBusto")
            val t_Frente = it.getString("etFrente")
            val t_Espalda = it.getString("etEspalda")
            val t_Cintura = it.getString("etCintura")
            val t_TallaF = it.getString("etTallaF")
            val t_TallaE = it.getString("etTallaE")
            val t_LargoF = it.getString("etLarFal")
            val t_LargoM = it.getString("etLarMan")
            val t_PunoA = it.getString("etPunAlto")
            val t_PunoB = it.getString("etPunBajo")
            val T_Cadera = it.getString("etCadera")

            tCarac.setText("$t_Carac")
            tTelas.setText("$t_Telas")
            tPinBusto.setText("$t_PinBusto")
            tDisBusto.setText("$t_DisBusto")
            tBusto.setText("$t_Busto")
            tFrente.setText("$t_Frente")
            tEspalda.setText("$t_Espalda")
            tCintura.setText("$t_Cintura")
            tTallaF.setText("$t_TallaF")
            tTallaE.setText("$t_TallaE")
            tLargoF.setText("$t_LargoF")
            tLargoM.setText("$t_LargoM")
            tPunoA.setText("$t_PunoA")
            tPunoB.setText("$t_PunoB")
            TCadera.setText("$T_Cadera")

        }

        btn_Edit.setOnClickListener{
            var intent = Intent(this, editOrderActivity::class.java)
            val a : Bundle = Bundle()
            a.putString("nom",nom)
            intent.putExtras(a)
            startActivity(intent)
        }
    }

    fun regresar(view: View){
        onBackPressed()
    }
}
