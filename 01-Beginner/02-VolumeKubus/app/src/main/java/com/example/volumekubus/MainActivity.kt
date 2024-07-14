package com.example.volumekubus

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var idEdge: TextView
    private lateinit var idBtnCalc: Button
    private lateinit var idResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        idEdge = findViewById(R.id.idEdge)
        idBtnCalc = findViewById(R.id.idBtnCalc)
        idResult = findViewById(R.id.idResult)
        idBtnCalc.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.idBtnCalc) {
            val inputSisi = idEdge.text.toString()
            var isEmptyFields = false
            if (inputSisi.isEmpty()) {
                isEmptyFields = true
                idEdge.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val voumeSisi = inputSisi.toDouble() * inputSisi.toDouble() * inputSisi.toDouble()
                idResult.text = voumeSisi.toString()
            }

        }
    }
}