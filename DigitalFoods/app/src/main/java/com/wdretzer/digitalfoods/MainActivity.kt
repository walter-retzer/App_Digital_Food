package com.wdretzer.digitalfoods

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

private lateinit var progressSplashBar: ProgressBar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Desabilita a Action Bar que exibe o nome do Projeto:
        getSupportActionBar()?.hide()

        progressSplashBar = findViewById(R.id.progressSplashBar)

        val maxSplashTime: Long = 5000
        var progressSplash: Long = 0
        val percentResult = maxSplashTime / 101

        for (x in 0..100) {
            Handler().postDelayed({
                progressSplashBar.progress = x
            }, progressSplash)
            progressSplash = progressSplash + percentResult
        }

        Handler().postDelayed({
            startActivity(Intent(this, Login::class.java))
            finish()
        }, maxSplashTime)


    }


}