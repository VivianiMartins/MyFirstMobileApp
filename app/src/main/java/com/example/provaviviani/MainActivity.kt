package com.example.provaviviani

import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import android.content.Intent
import android.widget.TextView
import android.content.Context
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Definindo a Visão
        setContentView(R.layout.activity_main)
        val btLogin = findViewById<Button>(R.id.buttonLogin)
        val btPassword = findViewById<Button>(R.id.buttonPassword)
        val btAccess = findViewById<Button>(R.id.buttonAccess)

        //Eventos:
        btLogin.setOnClickListener {
            val tLogin = findViewById<TextView>(R.id.editTextTextEmailAddress)
            val tSenha = findViewById<TextView>(R.id.editTextNumberPassword)
            val login = tLogin.text.toString()
            val senha = tSenha.text.toString()

            if(login == "viviani" && senha == "1234") {
                val intent = Intent(context, BemVindoActivity::class.java)
                val params = Bundle()
                params.putString("nome", "Viviani")
                intent.putExtras(params)
                startActivity(intent)
            } else {
                toast("Login ou Senha incorretos!!")
            }
        }

        btPassword.setOnClickListener {
            val intent = Intent(context, PasswordRecoverActivity::class.java)
            startActivity(intent)
        }

        btAccess.setOnClickListener {
            val intent = Intent(context, CreateAccessActivity::class.java)
            val params = Bundle()
            intent.putExtras(params)
            startActivity(intent)
        }
    }

    private fun toast(s: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, s, length).show()
    }

}


