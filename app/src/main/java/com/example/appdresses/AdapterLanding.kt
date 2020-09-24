package com.example.appdresses

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdresses.R
import kotlinx.android.synthetic.main.item_landing.view.*

class AdapterLanding(val data: List<ItemLanding>): RecyclerView.Adapter<AdapterLanding.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(
            parent.inflate(
                R.layout.item_landing
            )
        )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView:View?):RecyclerView.ViewHolder(itemView!!){
        fun bindView(itemLanding: ItemLanding){
            with(itemLanding){
                itemView.txtname.text = name
                itemView.txtF.text = eventF
                itemView.txtTel.text = "${String.format("%d",tel)}"
            }
        }
    }

}