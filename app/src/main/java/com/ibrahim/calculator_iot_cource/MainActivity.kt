package com.ibrahim.calculator_iot_cource

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression

lateinit var tvEquation: TextView
lateinit var tvTotal: TextView

lateinit var btn1: Button
lateinit var btn2: Button
lateinit var btn3: Button
lateinit var btn4: Button
lateinit var btn5: Button
lateinit var btn6: Button
lateinit var btn7: Button
lateinit var btn8: Button
lateinit var btn9: Button
lateinit var btn0: Button

lateinit var btnDot: Button
lateinit var btnEqual: Button

lateinit var btnAdd: Button
lateinit var btnSub: Button
lateinit var btnMulti: Button
lateinit var btnDiv: Button
lateinit var btnPercent: Button

lateinit var btnClear: Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        onClickButtons()
    }

    private fun initViews() {
        tvEquation = findViewById(R.id.tv_equation)
        tvTotal = findViewById(R.id.tv_total)

        btn1 = findViewById(R.id.btn_one)
        btn2 = findViewById(R.id.btn_two)
        btn3 = findViewById(R.id.btn_three)
        btn4 = findViewById(R.id.btn_four)
        btn5 = findViewById(R.id.btn_five)
        btn6 = findViewById(R.id.btn_six)
        btn7 = findViewById(R.id.btn_seven)
        btn8 = findViewById(R.id.btn_eight)
        btn9 = findViewById(R.id.btn_nine)
        btn0 = findViewById(R.id.btn_zero)

        btnDot = findViewById(R.id.btn_dot)
        btnEqual = findViewById(R.id.btn_equal)

        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)
        btnMulti = findViewById(R.id.btn_multi)
        btnDiv = findViewById(R.id.btn_div)
        btnPercent = findViewById(R.id.btn_percent)

        btnClear = findViewById(R.id.btn_clear)
    }

    private fun onClickButtons() {
        btn1.setOnClickListener {
            tvEquation.text = addToEquation("1")
        }
        btn2.setOnClickListener {
            tvEquation.text = addToEquation("2")
        }
        btn3.setOnClickListener {
            tvEquation.text = addToEquation("3")
        }
        btn4.setOnClickListener {
            tvEquation.text = addToEquation("4")
        }
        btn5.setOnClickListener {
            tvEquation.text = addToEquation("5")
        }
        btn6.setOnClickListener {
            tvEquation.text = addToEquation("6")
        }
        btn7.setOnClickListener {
            tvEquation.text = addToEquation("7")
        }
        btn8.setOnClickListener {
            tvEquation.text = addToEquation("8")
        }
        btn9.setOnClickListener {
            tvEquation.text = addToEquation("9")
        }
        btn0.setOnClickListener {
            tvEquation.text = addToEquation("0")
        }
        btnDot.setOnClickListener {
            tvEquation.text = addToEquation(".")
        }
        btnAdd.setOnClickListener {
            tvEquation.text = addToEquation("+")
        }
        btnSub.setOnClickListener {
            tvEquation.text = addToEquation("-")
        }
        btnMulti.setOnClickListener {
            tvEquation.text = addToEquation("x")
        }
        btnDiv.setOnClickListener {
            tvEquation.text = addToEquation("÷")
        }
        btnPercent.setOnClickListener {
            tvEquation.text = addToEquation("%")
        }

        btnEqual.setOnClickListener {
            displayResult()
        }


        btnClear.setOnClickListener {
            tvEquation.text = ""
            tvTotal.text = ""
        }
    }

    fun addToEquation(buttonValue: String): String {
        return "${tvEquation.text}$buttonValue"
    }

    fun convertEquationSymbols(): String {
        var symbol = tvEquation.text.replace(Regex("÷"), "/")
        symbol = symbol.replace(Regex("x"), "*")
        return symbol
    }

    fun displayResult() {
        try {


            val symbol = convertEquationSymbols()
            val result = Expression(symbol).calculate()
            if (result.isNaN()) {
                tvTotal.text = "Error"
                tvTotal.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.design_default_color_error
                    )
                )
            } else {
                tvTotal.text = result.toString()
                tvTotal.setTextColor(ContextCompat.getColor(this, R.color.greenColor))

            }
        } catch (e: Exception) {
            tvTotal.text = "Error"
            tvTotal.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.design_default_color_error
                )
            )
        }
    }
}
