package com.wdretzer.digitalfoods

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


@SuppressLint("WrongConstant")
class ListaRestaurantes : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<AdapterRestaurantes.RestauranteViewHolder>? = null

    private val recycler by lazy {
        RecyclerView(this)
    }

    private val manager by lazy {
        LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    }

    private var imagens =
        intArrayOf(
            R.drawable.cervejas,
            R.drawable.feijoada,
            R.drawable.hamburguer,
            R.drawable.comidabrasileira,
            R.drawable.espetinhos,
            R.drawable.taverna,
            R.drawable.churrasco,
            R.drawable.salmao
        )

    private val restaurantes = listOf(
        "Cervejaria BierHütte",
        "Tropeiro Sorocabano",
        "Hamburgueria Paulista",
        "Big Prato",
        "Espeto Medieval",
        "Taverna dos Monges",
        "O Braseiro",
        "Caravela Bar"
    )

    private val endereços = listOf(
        "Alameda das Vitórias, 555 - Sorocaba",
        "Alameda das Virtudes, 127 - Sorocaba",
        "Alameda dos Corajosos, 171 - Sorocaba",
        "Alameda da Discódia, 777 - Sorocaba",
        "Alameda das Araucárias, 69 - Sorocaba",
        "Alameda dos Bosques, 333 - Sorocaba",
        "Alameda dos Eucaliptos, 87 - Sorocaba",
        "Alameda das Violetas, 512 - Sorocaba"
    )

    private val horarios = listOf(
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


        recycler.layoutManager = manager
        recycler.adapter = AdapterRestaurantes(this, restaurantes, endereços, horarios, imagens)

    }
}