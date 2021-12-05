package com.wdretzer.digitalfoods

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPratos(
    val contex: Context,
    private val listaPratos: List<String>,
    private val listener1: AdapterPratos.OnItemClickListener,
    private val imagens1: IntArray
) :
    RecyclerView.Adapter<AdapterPratos.PratosViewHolder>() {

    override fun onCreateViewHolder(
        group: ViewGroup, viewType: Int
    ): AdapterPratos.PratosViewHolder {
        return PratosViewHolder(
            LayoutInflater.from(contex).inflate(R.layout.pratos_recycler, group, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterPratos.PratosViewHolder, position: Int) {
        val nomeDosPratos: String = listaPratos[position]

        holder.prato.text = nomeDosPratos
        holder.imagemPratos.setImageResource(imagens1[position])

    }

    override fun getItemCount(): Int = listaPratos.size

    inner class PratosViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var prato: TextView = view.findViewById(R.id.descriçãoPrato)
        var imagemPratos: ImageView = view.findViewById(R.id.imagemPratos)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener1.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
