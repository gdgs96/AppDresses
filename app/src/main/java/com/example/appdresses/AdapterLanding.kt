package com.example.appdresses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdresses.R
import com.example.appdresses.presentation.main.ClickListener
import kotlinx.android.synthetic.main.item_landing.view.*
//Creacion del recycler View y obtencion de datos para dar imagen de los clientes pendientes
class AdapterLanding(val lista: ArrayList<ItemLanding>,val context:Context, var clickListener: ClickListener):
    RecyclerView.Adapter<AdapterLanding.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_landing,parent,false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nom.text = lista[position].editT_nom
        holder.event.text = lista[position].etF_Evento
        holder.tel.text = lista[position].etTelefono

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder(val view:View, listener: ClickListener):RecyclerView.ViewHolder(view), View.OnClickListener{
        val nom = view.txtname
        val tel = view.txtTel
        val event = view.txtF
        var vista = view
        var listener:ClickListener?= null

        init {
            this.listener = listener
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!! , adapterPosition)
        }


    }
}