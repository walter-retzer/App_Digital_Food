package com.wdretzer.digitalfoods

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRestaurantes(
    val contex: Context,
    private val restaurantes: List<String>,
    private val endereços: List<String>,
    private val horarios: List<String>,
    private val imagens: IntArray,
    private val listener: OnItemClickListener

) :
    RecyclerView.Adapter<AdapterRestaurantes.RestauranteViewHolder>() {

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): RestauranteViewHolder {
        return RestauranteViewHolder(
            LayoutInflater.from(contex).inflate(R.layout.card_restaurante, group, false)
        )
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val nomeDosRestaurantes: String = restaurantes[position]
        val endereçoDosRestaurantes: String = endereços[position]
        val horarioDosRestaurantes: String = horarios[position]

        holder.textNome.text = nomeDosRestaurantes
        holder.textEndereço.text = endereçoDosRestaurantes
        holder.textHorario.text = horarioDosRestaurantes
        holder.imagemRestaurante.setImageResource(imagens[position])

    }

    override fun getItemCount(): Int = restaurantes.size

    inner class RestauranteViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        var textNome: TextView = view.findViewById(R.id.nomeRestaurante)
        var textEndereço: TextView = view.findViewById(R.id.nomeEndereço)
        var textHorario: TextView = view.findViewById(R.id.horario)
        var imagemRestaurante: ImageView = view.findViewById(R.id.imagemRestaurante)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }

        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}