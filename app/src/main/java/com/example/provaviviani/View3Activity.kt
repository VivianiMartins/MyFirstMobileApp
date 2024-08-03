package com.example.provaviviani

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.app.NavUtils


class View3Activity : ComponentActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Visões
        setContentView(R.layout.activity_view3)
        val textView = findViewById<TextView>(R.id.textName)

        //Args
        val args = intent.extras
        val nome = args?.getString("nome")
        textView.text = "$nome"


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

}