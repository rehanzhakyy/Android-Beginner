package com.example.luassegitiga

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var idBase: EditText
    private lateinit var idHeight: EditText
    private lateinit var idBtnCalculate: Button
    private lateinit var idTvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        idBase = findViewById(R.id.idBase)
        idHeight = findViewById(R.id.idHeight)
        idTvResult = findViewById(R.id.idTvResult)
        idBtnCalculate = findViewById(R.id.idBtnCalculate)
        idBtnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            idTvResult.text = result
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, idTvResult.text.toString())
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.idBtnCalculate) {
            val base = idBase.text.toString().trim()
            val height = idHeight.text.toString().trim()

            var isEmptyFields = false
            if (base.isEmpty()) {
                isEmptyFields = true
                idBase.error = "Field ini tidak boleh kosong"
            }
            if (height.isEmpty()) {
                isEmptyFields = true
                idHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val luas = 0.5 * (base.toDouble() * height.toDouble())
                idTvResult.text = luas.toString()
            }


        }
    }
}