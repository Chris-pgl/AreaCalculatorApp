package com.example.volumeareaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

import java.util.Locale

class Prism_Activity : AppCompatActivity() {

    private lateinit var editTextPrism: EditText
    private lateinit var editTextHeightPrism: EditText
    private lateinit var result: TextView
    private lateinit var imgPrism: ImageView
    private lateinit var btnPrism: Button
    private lateinit var btnCalcPrism: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prism)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        editTextPrism = findViewById(R.id.editText_prism)

        //tolto e devo sistemarlo dal xml
        //editTextHeightPrism = findViewById(R.id.editText_height_prism)
        result = findViewById(R.id.result_prism)
        imgPrism = findViewById(R.id.prism_img_activity)
        btnPrism = findViewById(R.id.btn_prism_home)
        btnCalcPrism = findViewById(R.id.btn_calculate_prism)

        imgPrism.setImageResource(R.drawable.prism)

        btnPrism.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnCalcPrism.setOnClickListener {
            val baseArea = editTextPrism.text.toString().toDoubleOrNull()
            val height = editTextHeightPrism.text.toString().toDoubleOrNull()

            if (baseArea == null || height == null ||
                baseArea <= 0 || height <= 0
            ) {
                result.text = "Please enter valid positive numbers"
            } else {
                val volume = baseArea * height
                result.text = String.format(
                    Locale.US,
                    "V = %.2f",
                    volume
                )
            }
        }
    }
}
