package com.example.lotrica_aula29_08

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class loginActivity : AppCompatActivity() {

    private lateinit var textusuario: EditText
    private lateinit var textsenha: EditText
    private lateinit var btentrar: Button
    private lateinit var btencerrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_main)

        btentrar = findViewById(R.id.btentrar)
        btencerrar = findViewById(R.id.btentrar)
        textusuario = findViewById(R.id.textusuario)
        textsenha = findViewById(R.id.textsenha)

        btentrar.setOnClickListener {

            val usuariostring = textusuario.text.toString().trim()
            val senhastring = textsenha.text.toString().trim()

            val usuariocorreto = "Gabriel"
            val senhacorreta = "gabriel726"

            if (usuariostring.isNotEmpty() && senhastring.isNotEmpty())
                if (usuariostring == usuariocorreto && senhastring == senhacorreta) {
                    val login = Intent(this, escolherActivity::class.java)
                    startActivity(login)
                } else {
                    Toast.makeText(this, "Usuário ou Senha incorreto!", Toast.LENGTH_SHORT).show()
                }
                else {
                Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_SHORT).show()
            }
        }
            btencerrar.setOnClickListener {
            finishAffinity()
            }
        }
    }
