package com.example.appdresses.presentation.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appdresses.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_order2.*
import java.io.Serializable

class order2Activity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order2)

        var Bundle=intent.extras
        var id = intent.getStringExtra("id")
        var map1 = intent.getSerializableExtra("map1")
        var ema = intent.getStringExtra("email")
        println(map1)

        btnsig.setOnClickListener{
            action(map1,id,ema)
            //validateText()
        }

    }


    fun btnfo2_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }
    fun action(map1: Serializable?, id:String?, ema:String?){
        var intent = Intent(this, order3Activity::class.java)
        var order2 = hashMapOf("etPinBusto" to etPinBusto.text.toString(),
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
            "etPunBajo" to etPunBajo.text.toString())
        val mp1 : Bundle = Bundle()
        val mp2 : Bundle = Bundle()
        val iD : Bundle = Bundle()


        mp1.putSerializable("map1", map1)
        mp2.putSerializable("map2", order2)
        iD.putString("id",id)
        intent.putExtras(mp1)
        intent.putExtras(mp2)
        intent.putExtras(iD)

        startActivity(intent)
    }

    private fun validateText() {

    }
}
