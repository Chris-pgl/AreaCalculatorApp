package com.example.volumeareaapp

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView
    lateinit var shapesArrayList: ArrayList<Shape>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        gridView = findViewById(R.id.gridView)
        shapesArrayList = ArrayList()

        shapesArrayList.add(Shape(R.drawable.sphere, "Sphere"))
        shapesArrayList.add(Shape(R.drawable.cylinder, "Cylinder"))
        shapesArrayList.add(Shape(R.drawable.cube, "Cube"))
        shapesArrayList.add(Shape(R.drawable.prism, "Prism"))

        val myCustomAdapter = MyCustomAdapter(this, shapesArrayList)
        gridView.adapter = myCustomAdapter
        gridView.numColumns = 2
    }
}