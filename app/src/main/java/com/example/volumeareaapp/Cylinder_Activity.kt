package com.example.volumeareaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Cylinder_Activity : AppCompatActivity() {

    lateinit var editText_cylinder: EditText
    lateinit var editText_height: EditText
    lateinit var title_cylinder: TextView
    lateinit var result: TextView
    lateinit var imgCylinder: ImageView
    lateinit var btn_cylinder: Button
    lateinit var btn_calc_cylinder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_cylinder)

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        imgCylinder = findViewById(R.id.cylinder_img_activity)
        imgCylinder.setImageResource(R.drawable.cylinder)

        editText_cylinder = findViewById(R.id.editText_cylinder)
        editText_height = findViewById(R.id.editText_cylinder)

        title_cylinder = findViewById(R.id.title_cylinder)
        result = findViewById(R.id.result_cylinder)

        btn_cylinder = findViewById(R.id.btn_cylinder_home)
        btn_calc_cylinder = findViewById(R.id.btn_calculate_cylinder)

        // Return to MainActivity
        btn_cylinder.setOnClickListener {

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }

        // Calculate Cylinder Volume
        btn_calc_cylinder.setOnClickListener {

            val radius = editText_cylinder.text.toString()
            val height = editText_height.text.toString()

            if (radius.isEmpty() || height.isEmpty()) {

                result.text = "Please enter all values"

            } else {

                val r = radius.toDoubleOrNull()
                val h = height.toDoubleOrNull()

                if (r == null || h == null || r <= 0 || h <= 0) {

                    result.text = "Please enter valid values"

                } else {

                    // V = PI * r^2 * h

                    val volume = Math.PI * Math.pow(r, 2.0) * h

                    result.text = String.format(
                        java.util.Locale.US,
                        "V = %.2f m³",
                        volume
                    )
                }
            }
        }
    }
}
