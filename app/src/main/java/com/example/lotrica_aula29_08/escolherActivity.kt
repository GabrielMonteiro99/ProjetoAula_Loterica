package com.example.lotrica_aula29_08

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class escolherActivity : AppCompatActivity() {

    private lateinit var btmegasena: Button
    private lateinit var btlotofacil: Button
    private lateinit var btquina: Button
    private lateinit var btlotomania: Button
    private lateinit var btencerrar: Button
    private lateinit var btvoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.escolher)

        btmegasena = findViewById(R.id.btmegasena)
        btlotofacil = findViewById(R.id.btlotofacil)
        btquina = findViewById(R.id.btquina)
        btlotomania = findViewById(R.id.btlotomania)
        btvoltar = findViewById(R.id.btvoltar)
        btencerrar = findViewById(R.id.btencerrar)

        btmegasena.setOnClickListener {
            var telasena: Intent
            telasena = Intent(this, megasenaActivity::class.java)
            startActivity(telasena)
        }
        btlotofacil.setOnClickListener {
            var telafacil: Intent
            telafacil = Intent(this, lotofacilActivity::class.java)
            startActivity(telafacil)
        }
        btquina.setOnClickListener {
            var telaquina: Intent
            telaquina = Intent(this, quinaActivity::class.java)
            startActivity(telaquina)
        }
        btlotomania.setOnClickListener {
            var telamania: Intent
            telamania = Intent(this, lotomaniaActivity::class.java)
            startActivity(telamania)
        }
        btvoltar.setOnClickListener {
            var telavoltar: Intent
            telavoltar = Intent(this, loginActivity::class.java)
            startActivity(telavoltar)
        }
        btencerrar.setOnClickListener {
            finishAffinity()
        }
    }
}
