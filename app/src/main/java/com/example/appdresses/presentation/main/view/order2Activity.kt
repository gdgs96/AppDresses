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
    lateinit var tPinBusto:String
    lateinit var tDisBusto:String
    lateinit var tBusto:String
    lateinit var tFrente:String
    lateinit var tEspalda:String
    lateinit var tCintura:String
    lateinit var tTallaF:String
    lateinit var tTallaE:String
    lateinit var tCadera:String
    lateinit var tLarFal:String
    lateinit var tLarMan:String
    lateinit var tPunAlto:String
    lateinit var tPunBajo:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order2)

        //var Bundle=intent.extras
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
        //var map1 = intent.getSerializableExtra("map1")

        println("$tMama,$id,$fPedido,$fEvento,$tPruebas,$tPruebas2,$tTelefono,$tColor,$tAnticipo,$tPrecio")


        btnsig.setOnClickListener{
            action(tMama,id,fPedido,fEvento,tPruebas,tPruebas2,tTelefono,tColor,tAnticipo,tPrecio)
            //validateText()
        }

    }


    fun btnfo2_back(view: View){
        startActivity(Intent(this, MainActivityNav::class.java))
    }
    fun action(tMama:String?,id:String?,fPedido:String?,fEvento:String?,tPruebas:String?,tPruebas2:String?,tTelefono:String?,tColor:String?,tAnticipo:String?,tPrecio:String?){
        val intent = Intent(this, order3Activity::class.java)
        /*var order2 = hashMapOf("etPinBusto" to etPinBusto.text.toString(),
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
            "etPunBajo" to etPunBajo.text.toString())*/
        tPinBusto=etPinBusto.text.toString()
        tDisBusto=etDisBusto.text.toString()
        tBusto=etBusto.text.toString()
        tFrente=etFrente.text.toString()
        tEspalda=etEspalda.text.toString()
        tCintura=etCintura.text.toString()
        tTallaF=etTallaF.text.toString()
        tTallaE=etTallaE.text.toString()
        tCadera=etCadera.text.toString()
        tLarFal=etLarFal.text.toString()
        tLarMan=etLarMan.text.toString()
        tPunAlto=etPunAlto.text.toString()
        tPunBajo=etPunBajo.text.toString()
        val t_PinBusto : Bundle = Bundle()
        val t_DisBusto : Bundle = Bundle()
        val t_Busto : Bundle = Bundle()
        val t_Frente : Bundle = Bundle()
        val t_Espalda : Bundle = Bundle()
        val t_Cintura : Bundle = Bundle()
        val t_TallaF : Bundle = Bundle()
        val t_TallaE : Bundle = Bundle()
        val t_Cadera : Bundle = Bundle()
        val t_LarFal : Bundle = Bundle()
        val t_LarMan : Bundle = Bundle()
        val t_PunAlto : Bundle = Bundle()
        val t_PunBajo : Bundle = Bundle()

        t_PinBusto.putString("tPinBusto",tPinBusto)
        t_DisBusto.putString("tDisBusto",tDisBusto)
        t_Busto.putString("tBusto",tBusto)
        t_Frente.putString("tFrente",tFrente)
        t_Espalda.putString("tEspalda",tEspalda)
        t_Cintura.putString("tCintura",tCintura)
        t_TallaF.putString("tTallaF",tTallaF)
        t_TallaE.putString("tTallaE",tTallaE)
        t_Cadera.putString("tCadera",tCadera)
        t_LarFal.putString("tLarFal",tLarFal)
        t_LarMan.putString("tLarMan",tLarMan)
        t_PunAlto.putString("tPunAlto",tPunAlto)
        t_PunBajo.putString("tPunBajo",tPunBajo)

        intent.putExtras(t_PinBusto)
        intent.putExtras(t_DisBusto)
        intent.putExtras(t_Busto)
        intent.putExtras(t_Frente)
        intent.putExtras(t_Espalda)
        intent.putExtras(t_Cintura)
        intent.putExtras(t_TallaF)
        intent.putExtras(t_TallaE)
        intent.putExtras(t_Cadera)
        intent.putExtras(t_LarFal)
        intent.putExtras(t_LarMan)
        intent.putExtras(t_PunAlto)
        intent.putExtras(t_PunBajo)

        val t_mama : Bundle = Bundle()
        val iD : Bundle = Bundle()
        val f_pedido : Bundle = Bundle()
        val f_evento : Bundle = Bundle()
        val f_pruebas : Bundle = Bundle()
        val f_pruebas2 : Bundle = Bundle()
        val t_tel : Bundle = Bundle()
        val t_Col : Bundle = Bundle()
        val t_anticipo : Bundle = Bundle()
        val t_precio : Bundle = Bundle()

        t_mama.putString("tMama",tMama)
        iD.putString("id",id)
        f_pedido.putString("fPedido",fPedido)
        f_evento.putString("fEvento",fEvento)
        f_pruebas.putString("tPruebas",tPruebas)
        f_pruebas2.putString("tPruebas2",tPruebas2)
        t_tel.putString("tTelefono",tTelefono)
        t_Col.putString("tColor",tColor)
        t_anticipo.putString("tAnticipo",tAnticipo)
        t_precio.putString("tPrecio",tPrecio)
        /*val mp1 : Bundle = Bundle()
        val mp2 : Bundle = Bundle()

        mp1.putSerializable("map1", map1)
        mp2.putSerializable("map2", order2)

        intent.putExtras(mp1)
        intent.putExtras(mp2)*/
        intent.putExtras(t_mama)
        intent.putExtras(iD)
        intent.putExtras(f_pedido)
        intent.putExtras(f_evento)
        intent.putExtras(f_pruebas)
        intent.putExtras(f_pruebas2)
        intent.putExtras(t_tel)
        intent.putExtras(t_Col)
        intent.putExtras(t_anticipo)
        intent.putExtras(t_precio)


        startActivity(intent)
    }

    private fun validateText() {

    }
}
