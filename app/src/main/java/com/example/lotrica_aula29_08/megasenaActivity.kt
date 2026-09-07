package com.example.lotrica_aula29_08

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class megasenaActivity : AppCompatActivity() {

    private var limiteMaximo = 6
    private lateinit var btvoltar2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.megasena)

        val nescolhido = findViewById<TextView>(R.id.nescolhidos)
        val njogos = findViewById<Spinner>(R.id.njogos)
        val button = findViewById<Button>(R.id.button)
        btvoltar2 = findViewById<Button>(R.id.btvoltar2)

        val opcoesnumeros = (6..20).toList()
        val opcoesFormatadas = opcoesnumeros.map { "$it dezenas" }

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item,
            opcoesFormatadas
        )
        njogos.adapter = adapter


        njogos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                limiteMaximo = opcoesnumeros[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
        button.setOnClickListener {
            val sorteio = (1..60)
                .shuffled()
                .take(limiteMaximo)
                .sorted()

            val textoFormatado = sorteio.joinToString("-") { String.format("%02d", it) }

            nescolhido.text = "Jogo Sorteado:\n$textoFormatado"
        }
        btvoltar2.setOnClickListener {
            var telavoltar: Intent
            telavoltar = Intent(this, escolherActivity::class.java)
            startActivity(telavoltar)
        }
    }
}


