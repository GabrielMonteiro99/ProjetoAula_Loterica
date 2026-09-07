package com.example.lotrica_aula29_08

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class lotomaniaActivity : AppCompatActivity() {
    private var limiteMaximo = 50
    private lateinit var btvoltar5: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotomania)

        val nescolhido = findViewById<TextView>(R.id.nescolhidos)
        val button = findViewById<Button>(R.id.button)
        btvoltar5 = findViewById<Button>(R.id.btvoltar5)

        button.setOnClickListener {
            val sorteio = (0..99)
                .shuffled()
                .take(limiteMaximo)
                .sorted()

            val textoFormatado = sorteio.joinToString("-") { String.format("%02d", it) }

            nescolhido.text = "Jogo Sorteado:\n$textoFormatado"
        }
        btvoltar5.setOnClickListener {
            var telavoltar: Intent
            telavoltar = Intent(this, escolherActivity::class.java)
            startActivity(telavoltar)
        }
    }
}