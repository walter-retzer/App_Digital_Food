package com.wdretzer.digitalfoods

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

private lateinit var cadastrarUsuario: TextView
private lateinit var cadastrarEmail: TextView
private lateinit var confirmaSenha: TextView
private lateinit var cadastraSenha: TextView
private lateinit var botaoRegistrar: TextView
lateinit var posSnackbar: TextView

class CadastrarUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_usuario)

        // Desabilita a Action Bar que exibe o nome do Projeto:
        getSupportActionBar()?.hide()

        // Criando os elementos da Activity:
        cadastrarUsuario = findViewById(R.id.cadastrarNomeUsuario)
        cadastrarEmail = findViewById(R.id.cadastarEmailUsuario)
        cadastraSenha = findViewById(R.id.cadastrarSenhaUsuario)
        confirmaSenha = findViewById(R.id.repetirSenhaUsuario)
        botaoRegistrar = findViewById(R.id.btRegistrar)
        posSnackbar = findViewById(R.id.snackbar)

        // Verifica se o botão "REGISTRAR" foi clicado e executa a avaliação para verificar os campos preenchidos:
        botaoRegistrar.setOnClickListener {

            // verifica se o e-mail e senha estão preenchidos:
            if (cadastrarUsuario.getText().length == 0 || cadastrarEmail.getText().length == 0 || cadastraSenha.getText().length == 0 || confirmaSenha.getText().length == 0) {

                // criando um push de aviso na tela, através de um Snackbar caso, haja campos não preenchidos:
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorCadastrar),
                    R.string.camposVazios,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setAnchorView(posSnackbar)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

            // verifica se a senha possuí 6 dígitos:
            } else if (cadastraSenha.getText().length <= 5 || confirmaSenha.getText().length <= 5) {

                // criando um push de aviso, através de um Snackbar, caso a senha não tenha 6 dígitos:
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorCadastrar),
                    R.string.campoSenha,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setAnchorView(posSnackbar)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

            // verifica se o e-mail preenchido contém os caractéres: "@" e ".com":
            } else if (!cadastrarEmail.text.toString().contains("@") ||
                !cadastrarEmail.text.toString().contains(".com") ||
                !android.util.Patterns.EMAIL_ADDRESS.matcher(cadastrarEmail.text.toString())
                    .matches()
            ) {

                // criando um push de aviso, através de um Snackbar, caso o e-mail contém os caractéres: "@" e ".com" :
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorCadastrar),
                    R.string.campoEmail,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setAnchorView(posSnackbar)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

            // verifica se as senhas digitadas são iguais:
            } else if (cadastraSenha.text.toString() != confirmaSenha.text.toString()) {

                // criando um push de aviso, através de um Snackbar, caso as senhas não forem iguais:
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorCadastrar),
                    R.string.campoChecaSenha,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setAnchorView(posSnackbar)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

            // caso estejam ok os campos preenchidos, executa abaixo:
            } else {

                // criando um push de aviso, através de um Snackbar, confirmando os dados:
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorCadastrar),
                    R.string.campoDadosOk,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setAnchorView(posSnackbar)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

                Handler().postDelayed({
                    // chama a Activity Pagina Inicial após 2 seg.
                    iniciaActivity()
                }, 2000)
            }
        }
    }

    private fun iniciaActivity() {
        val intent = Intent(this, ListaRestaurantes::class.java)
        startActivity(intent)
    }

}
