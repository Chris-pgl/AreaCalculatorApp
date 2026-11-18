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
        //converView è una view dello screen che se esiste viene riciclata
        // se no ne creiamo una nuova ( quindi controlleremo se è null )
        convertView: View?,
        parent: ViewGroup
    ): View {

        val view: View
        val holder: MyViewHolder

        //Qui controlliamo se la view è nulla o no
        //per poterla ricilare nel caso ci c'è già una view creata
        if(convertView == null){
            //controlliamo la view se è nulla viene creata una nuova
            //Usiamo LayoutInflate è un componente importante del framework Android
            //gestisce la UI consente di definire la struttura della UI e il suo aspetto
            view = LayoutInflater.from(context)
                .inflate(R.layout.grid_item_layout,parent,false)

            holder = MyViewHolder()

            holder.shapeName = view.findViewById(R.id.textView)
            holder.shapeImg = view.findViewById(R.id.imageView)

            view.tag = holder
        }else{
            //se una view è fuori schermo -> viene riciclata
            view = convertView
            holder = view.tag as MyViewHolder
        }

        val shape = shapesArrayList[position]
        holder.shapeName.text = shape.shapeName
        holder.shapeImg.setImageResource(shape.shapeImg)

        return view
    }

}