package com.example.aplicativo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var numero = 0
    var tentativas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        numero = Random.nextInt(1, 10)
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "O número sorteado foi $numero", LENGTH_SHORT).show()
        Toast.makeText(this, "O jogo vai começar", LENGTH_SHORT).show()

        tentativas = 0
    }

    fun cliqueBotao(v: View) {
        if (tentativas >= 3) {
            return
        }

        tentativas++
        val palpite = txtPalpite.text.toString().toInt()
        var texto = ""
        if (palpite == numero) {
            when (tentativas) {
                1 -> texto = "Nossa, você tem muita sorte!"
                2 -> texto = "Você tem sorte :)"
                3 -> texto = "Essa foi por pouco!"
            }
        } else {
            when (tentativas) {
                1, 2 -> texto = "Tente novamente"
                3 -> texto = "Não foi dessa vez, mas não desista!"
            }
        }

        Toast.makeText(this, texto, LENGTH_SHORT).show()
    }
}