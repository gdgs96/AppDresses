package com.example.appdresses.presentation.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appdresses.AdapterLanding
import com.example.appdresses.ItemLanding
import com.example.appdresses.R
import com.example.appdresses.presentation.main.ClickListener
import com.example.appdresses.presentation.main.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_navmain.*
import kotlinx.android.synthetic.main.activity_navmain.view.*
import kotlinx.android.synthetic.main.activity_order.*
import org.jetbrains.anko.support.v4.pagerTitleStrip

class MainActivityNav : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var email: TextView
    val db = FirebaseFirestore.getInstance()
    private val lista: ArrayList<ItemLanding> = ArrayList()
    private var adapterLanding: AdapterLanding? = null


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

        adapterLanding = AdapterLanding(lista,this, object: ClickListener{
            override fun onClick(vista: View, position: Int) {
                Toast.makeText(applicationContext, lista[position].editT_nom, Toast.LENGTH_SHORT).show()
                val nombre = lista[position].editT_nom
                action(nombre)
            }

        })
        rcViewLanding.layoutManager = GridLayoutManager(this, 1)
        rcViewLanding.adapter = adapterLanding

        print(currentUser?.email.toString())
        db.collection(currentUser?.email.toString()).get().addOnCompleteListener(){
            if (it.isSuccessful){
                lista.clear()
                for (documentos in it.result!!){
                    val nom = documentos.getString("editT_nom")
                    val tel = documentos.getString("etTelefono")
                    val event = documentos.getString("etF_Evento")

                    if (nom != null && tel !=null && event != null){
                        lista.add(ItemLanding(nom,event,tel))
                    }
                    adapterLanding?.notifyDataSetChanged()
                }
            }
            db.collection(currentUser?.email.toString()).addSnapshotListener{ snapshot, exception ->
                if(exception != null){
                    Toast.makeText(this,"Ah sucedido un error",Toast.LENGTH_SHORT).show()
                }

                lista.clear()
                snapshot?.forEach(){
                    val nom = it.getString("editT_nom")
                    val tel = it.getString("etTelefono")
                    val event = it.getString("etF_Evento")

                    if (nom != null && tel !=null && event != null){
                        lista.add(ItemLanding(nom,event,tel))
                    }
                }
                adapterLanding?.notifyDataSetChanged()
            }
        }


    }

    fun action(nombre:String){
        var intent = Intent(this, progressOrderActivity::class.java)
        val a : Bundle = Bundle()
        a.putString("nom",nombre)
        intent.putExtras(a)
        startActivity(intent)
    }

    fun boton(view: View){
        startActivity(Intent(this, orderActivity::class.java))
    }

    fun salir(view: View){
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }

}


