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

class lotofacilActivity : AppCompatActivity() {
    private var numeroMaximo = 15
    private lateinit var btvoltar3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotofacil)

        val nescolhido = findViewById<TextView>(R.id.nescolhidos)
        val njogos = findViewById<Spinner>(R.id.njogos)
        val button = findViewById<Button>(R.id.button)
        btvoltar3 = findViewById<Button>(R.id.btvoltar3)

        val opcoesnumeros = (15..20).toList()
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
                numeroMaximo = opcoesnumeros[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
        button.setOnClickListener {
            val sorteio = (1..25)
                .shuffled()
                .take(numeroMaximo)
                .sorted()

            val textoFormatado = sorteio.joinToString("-") { String.format("%02d", it) }

            nescolhido.text = "Jogo Sorteado:\n$textoFormatado"
        }
        btvoltar3.setOnClickListener {
            var telavoltar: Intent
            telavoltar = Intent(this, escolherActivity::class.java)
            startActivity(telavoltar)
        }
    }
}