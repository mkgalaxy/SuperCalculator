package com.github.sirmk80.supercalculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "UsePropertyAccessSyntax",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "LocalVariableName"
)
class ChangeDateActivity : AppCompatActivity() {
    private var txtDS: TextView? = null
    private var txtnmh2: TextView? = null
    private var txt8: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.changedate_activity)
        val btnDate: Button = findViewById(R.id.btn1)
        txtDS  = findViewById(R.id.txtDS)
        txtnmh2 = findViewById(R.id.txtnmh2)
        txt8 = findViewById(R.id.txt8)
        btnDate.setOnClickListener {
            clickDatePicker()
        }
    }
    private fun clickDatePicker(){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd =DatePickerDialog(this,
            {view, year, month, dayOfMonth ->
                Toast.makeText(this, " $year "+"/${month+1}"+
                "/$dayOfMonth", Toast.LENGTH_SHORT).show()
                val selectedDate = "$dayOfMonth/${month+1}/$year"
                txtDS?.setText(selectedDate)
                val DF = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = DF.parse(selectedDate)
                theDate?.let {
                    val SDIM = theDate.time / 60000
                    val currentDate = DF.parse(DF.format(System.currentTimeMillis()))
                    currentDate.let {
                        val CDIM = currentDate.time / 60000
                        val DIM = CDIM - SDIM
                        txtnmh2?.text = DIM.toString()
                        val SDIH = theDate.time / 3600000
                        val CDIH = currentDate.time / 3600000
                        val DIH = CDIH - SDIH
                        txt8?.text = DIH.toString()
                    }

                }

            },
            year, month, day)
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}
