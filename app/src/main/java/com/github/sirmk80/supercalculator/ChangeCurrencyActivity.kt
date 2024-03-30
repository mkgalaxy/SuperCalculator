@file:Suppress("KotlinRedundantDiagnosticSuppress", "RedundantSuppression")

package com.github.sirmk80.supercalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


@Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE", "UNUSED_VALUE", "UnusedImport",
    "KotlinConstantConditions"
)
class ChangeCurrencyActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currencychanger_activity)
        val btnSpinner: Button = findViewById(R.id.btnSpinner)
        val txtSpinner: TextView = findViewById(R.id.txtSpinner)
        val dollar: RadioButton = findViewById(R.id.dollar)
        val euro: RadioButton = findViewById(R.id.euro)
        val pound: RadioButton = findViewById(R.id.pound)
        val aed: RadioButton = findViewById(R.id.dirham)
        val yuan: RadioButton = findViewById(R.id.yuan)
        val lira: RadioButton = findViewById(R.id.lira)
        val dinar : RadioButton = findViewById(R.id.dinar)
        val  yen : RadioButton = findViewById(R.id.yen)
        btnSpinner.setOnClickListener {
            if(txtSpinner.text.isEmpty()){
                Toast.makeText(this,"Error!",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!dollar.isChecked && !euro.isChecked && !pound.isChecked &&
                !aed.isChecked && !yuan.isChecked && !lira.isChecked && !dinar.isChecked
                && !yen.isChecked) {
                Toast.makeText(
                    this, "Error!",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val price = txtSpinner.text.toString().toDouble()
            var result = 0.0
            if (dollar.isChecked)
                result = price / 61658
            else if (euro.isChecked)
                result = price / 66644
            else if (pound.isChecked)
                result = price / 77923
            else if (aed.isChecked)
                result = price / 16895
            else if (yuan.isChecked)
                result = price / 8550
            else if (lira.isChecked)
                result = price / 1915
            else if (dinar.isChecked)
                result = price / 200750
            else if (yen.isChecked)
                result = price / 40800
            Toast.makeText(this,String.format("%.2f",result),Toast.LENGTH_LONG).show()
        }
    }
}