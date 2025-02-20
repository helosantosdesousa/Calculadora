package com.helosantosdesousa.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout


class MainActivity : AppCompatActivity() {

    lateinit var etNumber: EditText
    lateinit var gridLayout: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

// Inicia os elementos da interface
        etNumber = findViewById(R.id.etNumber)
        gridLayout = findViewById(R.id.gridLayout)

        findViewById<Button>(R.id.bt_igual).setOnClickListener {
            //val expression = etNumber.text.toString()
            val result = "teste"
            //val result = evaluateExpression(expression) // Função para avaliar a expressão
            etNumber.setText(result.toString()) // Exibe o resultado no EditText
        }



    }
}