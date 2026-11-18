package com.example.volumeareaapp

import android.content.Intent
import android.os.Bundle
import android.util.Log.i
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SphereActivity : AppCompatActivity() {

    lateinit var editText_sphere: EditText
    lateinit var title_sphere: TextView
    lateinit var result: TextView
    lateinit var imgSphere: ImageView
    lateinit var btn_sphere: Button
    lateinit var btn_calc_sph: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sphere)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imgSphere = findViewById(R.id.sphere_img_activity)
        imgSphere.setImageResource(R.drawable.sphere)

        editText_sphere = findViewById(R.id.editText_sphere)
        title_sphere = findViewById(R.id.title_sphere)
        result = findViewById(R.id.result_sphere)
        btn_sphere = findViewById(R.id.btn_sphere_home)
        btn_calc_sph = findViewById(R.id.btn_calculate_sphere)


        btn_sphere.setOnClickListener {
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        btn_calc_sph.setOnClickListener {
            val radius = editText_sphere.text.toString().toDoubleOrNull()

            if (radius == null || radius <= 0) {
                result.text = "Please enter a valid positive radius"
            } else {
                // V = (4/3) * PI * r^3
                val volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0)

                result.text = String.format(
                    java.util.Locale.US,
                    "V = %.2f",
                    volume
                )
            }
        }
    }




}