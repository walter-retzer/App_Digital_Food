package com.wdretzer.digitalfoods

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@SuppressLint("WrongConstant")
class ListaRestaurantes : AppCompatActivity(), AdapterRestaurantes.OnItemClickListener {

    private val recycler by lazy {
        RecyclerView(this)
    }

    private val manager by lazy {
        LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    }

    private var imagensRestaurantes =
        intArrayOf(
            R.drawable.cervejas,
            R.drawable.comidabrasileira,
            R.drawable.espetinhos,
            R.drawable.hamburguer,
            R.drawable.taverna,
            R.drawable.churrasco,
            R.drawable.feijoada,
            R.drawable.salmao
        )

    private val nomeRestaurantes = listOf(
        "Cervejaria BierHütte",
        "Big Prato",
        "O Braseiro",
        "Hamburgueria Paulista",
        "Taverna dos Monges",
        "Espeto Medieval",
        "Tropeiro Sorocabano",
        "Caravela Bar"
    )

    private val endereçosRestaurantes = listOf(
        "Alameda das Vitórias, 555 - Sorocaba",
        "Alameda das Virtudes, 127 - Sorocaba",
        "Alameda dos Corajosos, 171 - Sorocaba",
        "Alameda da Discórdia, 777 - Sorocaba",
        "Alameda das Araucárias, 69 - Sorocaba",
        "Alameda dos Bosques, 333 - Sorocaba",
        "Alameda dos Eucaliptos, 87 - Sorocaba",
        "Alameda das Violetas, 512 - Sorocaba"
    )

    private val horariosRestaurantes = listOf(
        "Fecha às 00:00",
        "Fecha às 00:30",
        "Fecha às 18:00",
        "Fecha às 23:00",
        "Fecha às 23:30",
        "Fecha às 01:30",
        "Fecha às 01:00",
        "Fecha às 23:50"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recycler)

        // Desabilita a Action Bar que exibe o nome do Projeto:
        getSupportActionBar()?.hide()

        // variável para checagem se houve clique sobre a position da recycler view
        val listener: AdapterRestaurantes.OnItemClickListener = this

        //parâmetros para a Recycler View
        recycler.layoutManager = manager
        recycler.adapter =
            AdapterRestaurantes(
                this,
                nomeRestaurantes,
                endereçosRestaurantes,
                horariosRestaurantes,
                imagensRestaurantes,
                listener
            )
    }

    // função para enviar os dados dos Pratos para a Activity Lista Prato, através de putExtra:
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Restaurante Selecionado.", Toast.LENGTH_SHORT).show()
        val nomeRestaurante = nomeRestaurantes[position]
        val photoRestaurante = imagensRestaurantes[position]

        //usando a classe Dados para passar algumas informações para a Activity Lista Prato:
        val dados = Dados(
            photoRestaurante,
            nomeRestaurante
        )

        val intent = Intent(this, ListaPratos::class.java).apply {

            putExtra("RESTAURANTE", dados)

        }
        startActivity(intent)

    }
}
