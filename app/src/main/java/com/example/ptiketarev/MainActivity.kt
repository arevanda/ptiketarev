package com.example.ptiketarev

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val ticketPrice = 25000
    private var ticketCount = 1

    private lateinit var tvTicketCount: TextView
    private lateinit var tvTotalPay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMinus = findViewById<MaterialButton>(R.id.btnMinus)
        val btnPlus = findViewById<MaterialButton>(R.id.btnPlus)
        val btnReset = findViewById<MaterialButton>(R.id.btnReset)

        tvTicketCount = findViewById(R.id.tvTicketCount)
        tvTotalPay = findViewById(R.id.tvTotalPay)

        btnPlus.setOnClickListener {
            ticketCount++
            updateUI()
        }

        btnMinus.setOnClickListener {
            if (ticketCount > 1) {
                ticketCount--
                updateUI()
            }
        }

        btnReset.setOnClickListener {
            ticketCount = 1
            updateUI()
        }

        updateUI()
    }

    private fun updateUI() {
        tvTicketCount.text = ticketCount.toString()
        val totalPay = ticketPrice * ticketCount
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        tvTotalPay.text = formatRupiah.format(totalPay).replace(",00", "")
    }
}