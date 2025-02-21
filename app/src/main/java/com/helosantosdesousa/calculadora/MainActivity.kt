package com.helosantosdesousa.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.gridlayout.widget.GridLayout

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber: EditText
    private lateinit var gridLayout: GridLayout

    private var number = ""
    private var n1: Double? = null
    private var n2: Double? = null
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumber = findViewById(R.id.etNumber)
        gridLayout = findViewById(R.id.gridLayout)

        getNumber()
        setOperators()
    }

    private fun getNumber() {
        val buttons = listOf(
            R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4,
            R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                val button = it as Button
                number += button.text
                etNumber.setText(number)
            }
        }
    }

    private fun setOperators() {
        val operators = mapOf(
            R.id.btSum to "+",
            R.id.btMinus to "-",
            R.id.btTimes to "*",
            R.id.btDivision to "/",
            R.id.btPercentage to "%"
        )

        for ((id, op) in operators) {
            findViewById<Button>(id).setOnClickListener {
                if (number.isNotEmpty()) {
                    n1 = number.toDoubleOrNull()
                    operator = op
                    number = ""
                    etNumber.setText("")
                }
            }
        }

        findViewById<Button>(R.id.btEquals).setOnClickListener {
            if (number.isNotEmpty()) {
                n2 = number.toDoubleOrNull()
                if (n1 != null && n2 != null && operator != null) {
                    val result = calculate(n1!!, n2!!, operator!!)
                    etNumber.setText(result.toString())
                    reset()
                }
            }
        }

        findViewById<Button>(R.id.btClear).setOnClickListener {
            reset()
            etNumber.setText("")
        }
    }

    private fun calculate(n1: Double, n2: Double, operator: String): Double {
        return when (operator) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> if (n2 != 0.0) n1 / n2 else Double.NaN
            "%" -> n1 * (n2 / 100)
            else -> 0.0
        }
    }

    private fun reset() {
        number = ""
        n1 = null
        n2 = null
        operator = null
    }
}
