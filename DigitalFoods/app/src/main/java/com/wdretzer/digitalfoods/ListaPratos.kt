package com.wdretzer.digitalfoods

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager

@SuppressLint("WrongConstant")
class ListaPratos : AppCompatActivity(), AdapterPratos.OnItemClickListener {

    private var imagensPratoHamburgueriaPaulista =
        intArrayOf(
            R.drawable.burger_bacon,
            R.drawable.burguer_bacon_crispy,
            R.drawable.burguer_double_bacon,
            R.drawable.burguer_especial_bacon,
            R.drawable.burguer_double_cheddar,
            R.drawable.burguer_kids,
            R.drawable.burguer_picles,
            R.drawable.burguer_salad,
            R.drawable.burguer_tradicional,
            R.drawable.burguer_triplo,
            R.drawable.burguer_vegano,
            R.drawable.burguer_vegano2,
            R.drawable.burguer_xcalabresa,
            R.drawable.burguer_xfrango,
            R.drawable.burguer_xqueijo,
            R.drawable.burguer_xtudo
        )

    private val listaPratosHamburgueriaPaulista = listOf(
        "Bacon Burger",
        "Bacon Crispy",
        "Double Bacon",
        "Especial Bacon",
        "Double Cheddar",
        "Hamburguer Kids",
        "Picles Burger",
        "Salad Burger",
        "Tradicional Burger",
        "Triplo Burger",
        "Vegano 1",
        "Vegano 2",
        "X Calabresa",
        "X Frango",
        "X Cheeses",
        "X Tudo"
    )

    private val descricaoPratosHamburgueriaPaulista = listOf(
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Picanha para as crin??as, acompanha batatas",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa e Picles Artesanal",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa",
        "Delicioso Hamburguer de Jaca com gr??os de lentilha",
        "Delicioso Hamburguer de Jaca com gr??os de lentilha e beterraba",
        "Delicioso Hamburguer que acompanha calabresas fritas",
        "Delicioso Lanche de Frango com catupiry",
        "Delicioso Lanche com Queijo Mussarela, Cheddar e Catupiry",
        "Delicioso Hamburguer de Picanha com Molho Especial da Casa"

    )

    private var imagensPratosCervejariaBierHutte =
        intArrayOf(
            R.drawable.cervejaria_brejapilsen,
            R.drawable.cervejaria_brejaipa,
            R.drawable.cervejaria_brejaredalle,
            R.drawable.cervejaria_brejaweiss,
            R.drawable.cervejaria_porcao_batata,
            R.drawable.cervejaria_porcao_batatabacon,
            R.drawable.cervejaria_porcao_calabresacomcebola,
            R.drawable.cervejaria_porcaobatatarustic,
            R.drawable.cervejaria_porcaobuffalowings,
            R.drawable.cervejaria_porcaochurrasco,
            R.drawable.cervejaria_porcaofrangopassarinho,
            R.drawable.cervejaria_porcaobolinhaqueijo
        )

    private val listaPratosCervejariaBierHutte = listOf(
        "Cerveja Pilsen",
        "Cerveja IPA",
        "Cerveja Red Alle",
        "Cerveja Weiss",
        "Por????o de Batata Frita",
        "Batata com Bacon",
        "Calabresa com Cebola",
        "Batata Rustica",
        "Buffalo Wings",
        "Churrasco Misto",
        "Frango a Passarinho",
        "Bolinha de Queijo"
    )

    private val descricaoPratosCervejariaBierHutte = listOf(
        "As cervejas Pilsen s??o caracterizadas por um l??pulo acentuado no aroma e sabor e por sua cor dourada brilhante.",
        "O estilo IPA tem seu equil??brio propositalmente puxado para o amargor, por ser feita com uma concentra????o maior de l??pulo.",
        "A bebida tem cor ??mbar m??dio a cobre avermelhado m??dio, contando com baixa forma????o de espuma composta pela tonalidade bege claro a bronzeada.",
        "A Weissbier (Weizenbier, ou simplesmente Weiss) ?? uma cerveja produzida a partir do malte de trigo. ?? uma cerveja clara, refrescante, com alta carbonata????o, final seco e com toque \"aveludado\"",
        "Deliciosa Por????o de Batata Frita. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Batata Frita com Bacon em peda??os. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Calabresa com Cebola em rodelas. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Batata Frita R??stica. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Buffalo Wings, acompanha molho de pimenta a parte. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Churrasco Misto, acompanha tiras de carne, lingui??a e p??o de alho. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Frango ?? Passarinho. \n\nServe at?? 4 pessoas..",
        "Deliciosa Por????o de Bolinhos Crocantes de Queijo. \n\nServe at?? 4 pessoas.."
    )

    private var imagensPratoDefault =
        intArrayOf(
            R.drawable.feijuka,
            R.drawable.picanha_mineira,
            R.drawable.tutu,
            R.drawable.figado,
            R.drawable.espetinhos,
            R.drawable.polenta_frango,
            R.drawable.vacatolada,
            R.drawable.leitoa_pururuca
        )

    private val listaPratosDefault = listOf(
        "Feijoada Completa",
        "Picanha Mineira",
        "Tutu",
        "F??gado com Jil??",
        "Espetinhos",
        "Polenta com Frango",
        "Vaca Atolada",
        "Leitoa ?? Pururuca"
    )

    private val descricaoPratosDefault = listOf(
        "Deliciosa Feijoada Completa, acompanha molho apimentado e 4 doses de cacha??a. \n\nServe at?? 4 pessoas.",
        "Deliciosa Picanha Mineira feita na pedra, acompanha molho especial. \n\nServe at?? 4 pessoas.",
        "Delicioso Tutu ?? mineira, acompanha arroz branco e salalda. \n\nServe at?? 2 pessoas.",
        "Deliciosa Por????o de F??gado com Jil?? acompanha molho apimentado e 4 doses de cacha??a. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Churrasco Misto, acompanha tiras de carne, lingui??a e p??o de alho. \n\nServe at?? 4 pessoas.",
        "Deliciosa Por????o de Polenta com Frango, acompanha arroz e salada. \n\nServe at?? 2 pessoas.",
        "Delicioso Prato de Vaca Atolada, acompanha arroz branco e salada. \n\nServe at?? 4 pessoas..",
        "Delicioso Prato de Leitoa ?? Pururuca, acompanha molho apimentado e 4 doses de cacha??a. \n\nServe at?? 4 pessoas."
    )


    var restaurante: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pratos)

        // Desabilita a Action Bar que exibe o nome do Projeto:
        getSupportActionBar()?.hide()

        var nomeDoRestaurante: TextView = findViewById(R.id.nomeRestaurante)
        var imagemRestaurante: ImageView = findViewById(R.id.imagemPricipalRestaurante)

        // Dados enviados pelo putExtra da Actyvity Lista de Restaurante
        val dadosRestaurante = intent.extras?.getParcelable<Dados>("RESTAURANTE")!!
        nomeDoRestaurante.setText(dadosRestaurante.nome)
        imagemRestaurante.setImageResource(dadosRestaurante.imagem)

        // declarando a recyclerview pela id
        val recyclerview = findViewById<RecyclerView>(R.id.pratos_recycler)

        // Criando um Grid Layout para a exibi????o dos Pratos
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        // vari??vel para checagem se houve clique sobre a position da recycler view
        val listener1: AdapterPratos.OnItemClickListener = this

        // checagem para exibir os pratos de acordo com o Restaurante Selecionado (clique sobre o Restaurante)
        if (dadosRestaurante.nome == "Hamburgueria Paulista") {
            restaurante = "Hamburgueria Paulista"
            recyclerview.adapter =
                AdapterPratos(
                    this,
                    listaPratosHamburgueriaPaulista,
                    listener1,
                    imagensPratoHamburgueriaPaulista
                )
        } else if (dadosRestaurante.nome == "Cervejaria BierH??tte") {
            restaurante = "Cervejaria BierH??tte"
            recyclerview.adapter =
                AdapterPratos(
                    this,
                    listaPratosCervejariaBierHutte,
                    listener1,
                    imagensPratosCervejariaBierHutte
                )
        } else {
            restaurante = dadosRestaurante.nome
            recyclerview.adapter =
                AdapterPratos(this, listaPratosDefault, listener1, imagensPratoDefault)
        }
    }

    // fun????o para enviar os dados dos Pratos para a Activity Detalhe Prato, atrav??s de putExtra
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Prato Selecionado.", Toast.LENGTH_SHORT).show()
        var nomePrato = ""
        var photoPrato = 0
        var descricaoPrato = ""

        // checagem para enviar os dados dos pratos de acordo com o Restaurante Selecionado (clique sobre o Restaurante)
        if (restaurante == "Hamburgueria Paulista") {
            nomePrato = listaPratosHamburgueriaPaulista[position]
            photoPrato = imagensPratoHamburgueriaPaulista[position]
            descricaoPrato = descricaoPratosHamburgueriaPaulista[position]
        } else if (restaurante == "Cervejaria BierH??tte") {
            nomePrato = listaPratosCervejariaBierHutte[position]
            photoPrato = imagensPratosCervejariaBierHutte[position]
            descricaoPrato = descricaoPratosCervejariaBierHutte[position]
        } else {
            nomePrato = listaPratosDefault[position]
            photoPrato = imagensPratoDefault[position]
            descricaoPrato = descricaoPratosDefault[position]
        }

        //usando a classe DadosPrato para passar algumas informa????es entre as activitys:
        val dados = DadosPratos(
            photoPrato,
            nomePrato,
            descricaoPrato
        )

        // usando uma intent para iniciar a Activity DetalhePrato
        val intent = Intent(this, DetalhePrato::class.java).apply {

            putExtra("PRATOS", dados)

        }
        startActivity(intent)

    }
}
