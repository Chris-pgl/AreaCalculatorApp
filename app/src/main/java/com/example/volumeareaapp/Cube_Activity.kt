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


class Cube_Activity : AppCompatActivity() {

    lateinit var editText_cube: EditText
    lateinit var title_cube: TextView
    lateinit var result: TextView
    lateinit var imgCube: ImageView
    lateinit var btn_cube: Button
    lateinit var btn_calc_cube: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_cube)

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

        imgCube = findViewById(R.id.cube_img_activity)
        imgCube.setImageResource(R.drawable.cube)

        editText_cube = findViewById(R.id.editText_cube)
        title_cube = findViewById(R.id.title_cube)
        result = findViewById(R.id.result_cube)

        btn_cube = findViewById(R.id.btn_sphere_home)
        btn_calc_cube = findViewById(R.id.btn_calculate_cube)

        // Return to MainActivity
        btn_cube.setOnClickListener {

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }

        // Calculate Cube Volume
        btn_calc_cube.setOnClickListener {

            val side = editText_cube.text.toString()

            if (side.isEmpty()) {

                result.text = "Please enter the side"

            } else {

                val length = side.toDoubleOrNull()

                if (length == null || length <= 0) {

                    result.text = "Please enter a valid side"

                } else {

                    // V = l^3

                    val volume = Math.pow(length, 3.0)

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
