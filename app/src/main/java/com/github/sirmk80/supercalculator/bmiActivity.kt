package com.github.sirmk80.supercalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

@Suppress("UNREACHABLE_CODE", "ClassName")
class bmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_activity)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        btnCalculate.setOnClickListener {
            val weight = etWeight.text.toString()
            val height = etHeight.text.toString()
            if (validateInput(weight, height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
                val bmi2D = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2D)
            }
        }
    }
    private fun validateInput(weight:String?,height:String?):Boolean{
        return when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this,"مقدار وزن وارد نشده است",Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this,"مقدار قد وارد نشده است",Toast.LENGTH_SHORT).show()
                return false
            }
            else ->{
                return true
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun displayResult(bmi:Float){
        val tvIndex = findViewById<TextView>(R.id.tvIndex)
        val tvResult = findViewById<TextView>(R.id.tvResults)
        val tvInfo = findViewById<TextView>(R.id.tvinfo)
        tvIndex.text = bmi.toString()
        tvInfo.text = "وضعیت نرمال بین 24.9-18.5می باشد"
        var resultText = ""
        var color = 0
        when{
            bmi in 0.0..10.5 ->{
                resultText = "مطمئنی که زنده ای!!!"
                color = R.color.under_underweight
            }
            bmi in 10.5..17.0 ->{
                resultText = "یکم بخور وزنت بیاد بالا"
                color = R.color.underweight2
            }
            bmi <18.5 ->{
                resultText = "لاغر"
                color = R.color.underweight
            }
            bmi in 18.5..24.9 ->{
                resultText = "نرمال"
                color = R.color.normal
            }
            bmi in 25.00..29.99 ->{
                resultText = "چاق"
                color = R.color.over_weight
            }
            bmi > 29.9 ->{
                resultText = "خیلی چاق"
                color = R.color.obese
            }
        }
        tvResult.setTextColor(ContextCompat.getColor(this,color))
        tvResult.text = resultText
    }
}