package com.wdretzer.digitalfoods

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

private lateinit var loginEmail: TextView
private lateinit var loginSenha: TextView
private lateinit var botaoLogin: TextView
private lateinit var botaoCadastrar: TextView


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Desabilita a Action Bar que exibe o nome do Projeto:
        getSupportActionBar()?.hide()

        // Criando os elementos da Activity:
        botaoLogin = findViewById(R.id.btLogin)
        loginEmail = findViewById(R.id.email_CadastrarUsuario)
        loginSenha = findViewById(R.id.senha_CadastrarUsuario)
        botaoCadastrar = findViewById(R.id.btLoginCadastrar)

        // Verifica se o botão "ENTRAR" foi clicado e executa a avaliação para verificar os campos preenchidos
        botaoLogin.setOnClickListener {

            // verifica se o e-mail e senha estão preenchidos:
            if (loginEmail.getText().length == 0 || loginSenha.getText().length == 0) {

                // criando um push de aviso na tela, através de um Snackbar caso, haja campos não preenchidos:
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorLayoutLogin),
                    R.string.camposVazios,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

                // verifica se o e-mail preenchido contém os caractéres: "@" e ".com":
            } else if (!loginEmail.text.toString().contains("@") ||
                !loginEmail.text.toString().contains(".com") ||
                !android.util.Patterns.EMAIL_ADDRESS.matcher(loginEmail.text.toString()).matches()
            ) {
                // criando um push de aviso, através de um Snackbar, caso o e-mail contém os caractéres: "@" e ".com" :
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorLayoutLogin),
                    R.string.campoEmail,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

                // verifica se a senha possuí 6 dígitos:
            } else if (loginSenha.getText().length <= 5) {

                // criando um push de aviso, através de um Snackbar, caso a senha não tenha 6 dígitos:
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorLayoutLogin),
                    R.string.campoSenha,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

                // caso estejam ok os campos preenchidos, executa abaixo:
            } else {

                // criando um push de aviso, através de um Snackbar, confirmando os dados:
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.coordinatorLayoutLogin),
                    R.string.campoDadosOk,
                    Snackbar.LENGTH_LONG
                )

                // configuração da cor do texto, e cor do background:
                mySnackbar.setTextColor(Color.WHITE)
                mySnackbar.setBackgroundTint(Color.DKGRAY)
                mySnackbar.show()

                Handler().postDelayed({
                    // chama a Activity Pagina Inicial após 2 seg.
                    iniciaActivity()
                }, 2000)


            }

        }

        // Verifica se o botão "ENTRAR" foi clicado e executa a avaliação para verificar os campos preenchidos
        botaoCadastrar.setOnClickListener {
            Handler().postDelayed({
                // chama a Activity Pagina Inicial após 2 seg.
                iniciaActivity1()
            }, 2000)
        }


    }

    private fun iniciaActivity() {
        val intent = Intent(this, ListaRestaurantes::class.java)
        startActivity(intent)
    }

    private fun iniciaActivity1() {
        val intent = Intent(this, CadastrarUsuario::class.java)
        startActivity(intent)
    }
}