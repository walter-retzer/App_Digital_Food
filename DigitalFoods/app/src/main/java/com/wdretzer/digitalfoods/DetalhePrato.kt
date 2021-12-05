package com.wdretzer.digitalfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalhePrato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_prato)

        // Desabilita a Action Bar que exibe o nome do Projeto:
        getSupportActionBar()?.hide()

        // variáveis da Tela Detalhe Prato
        var nomeDoPrato: TextView = findViewById(R.id.nomePrato)
        var pratoDescrição: TextView = findViewById(R.id.conteudoPratos)
        var imagemPrato: ImageView = findViewById(R.id.imagemDetalhePrato)

        // Dados enviados pelo putExtra da Actyvity ListaPratos:
        val dadosPratos = intent.extras?.getParcelable<DadosPratos>("PRATOS")!!

        imagemPrato.setImageResource(dadosPratos.imagem)
        nomeDoPrato.setText(dadosPratos.nome)
        pratoDescrição.setText(dadosPratos.descricao)
    }
}
