package com.example.volumeareaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


/**
 * questa classe sarà responsabile della creazione
 * di ogni item della griglia e di gestirne il contenuto
 * Adapter Class -> MyCustomAdapter
 */
class MyCustomAdapter(
    context: Context,
    private val shapesArrayList: ArrayList<Shape>
): ArrayAdapter<Shape>(
    context,
    R.layout.grid_item_layout,
    shapesArrayList)
{
    private val context = context

    private class MyViewHolder {
        lateinit var shapeImg: ImageView
        lateinit var shapeName: TextView
    }


    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view: View
        val holder: MyViewHolder

        if(convertView == null){
            view = LayoutInflater.from(context)
                .inflate(R.layout.grid_item_layout,parent,false)

            holder = MyViewHolder()

            holder.shapeName = view.findViewById(R.id.textView)
            holder.shapeImg = view.findViewById(R.id.imageView)

            view.tag = holder
        }else{

            view = convertView
            holder = view.tag as MyViewHolder
        }

        val shape = shapesArrayList[position]
        holder.shapeName.text = shape.shapeName
        holder.shapeImg.setImageResource(shape.shapeImg)

        return view
    }

}