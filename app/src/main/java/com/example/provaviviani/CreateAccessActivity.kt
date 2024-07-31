package com.example.provaviviani

import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class CreateAccessActivity : ComponentActivity() {
    private val context: Context get() = this
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Visões
        setContentView(R.layout.activity_create_access)
        val btAccess = findViewById<Button>(R.id.buttonAccess)

        //Eventos:
        btAccess.setOnClickListener {
            val tLogin = findViewById<TextView>(R.id.editTextTextEmailAddress)
            val tSenha = findViewById<TextView>(R.id.editTextNumberPassword)
            val tSenhaConfirm = findViewById<TextView>(R.id.editTextNumberPasswordConfirm)
            val login = tLogin.text.toString()
            val senha = tSenha.text.toString()
            val senhaConfirm = tSenhaConfirm.text.toString()

            if(senha === senhaConfirm) {
                val intent = Intent(context, MainActivity::class.java)
                val params = Bundle()
                params.putString("nome", login)
                intent.putExtras(params)
                startActivity(intent)
            } else {
                toast("As senhas não são iguais!!")
            }
        }


        //ativa o "up navigation" na actions bar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            //Tratamos o clique no botão de voltar (<--)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toast(s: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, s, length).show()
    }
}