package com.example.proyecto_android_final_iker_markel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var fragmento:Fragment, var listaLibros: MutableList<Libro>): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    inner class ViewHolder (v: View):RecyclerView.ViewHolder(v){
        var titulo: TextView =v.findViewById(R.id.Titulo)
        var autor: TextView =v.findViewById(R.id.Autor)
        var posicion:Int=-1
        init {
            v.setOnClickListener {

                val miBundle1: Bundle = bundleOf("id" to this.posicion)
                fragmento.findNavController()
                    .navigate(R.id.action_FirstFragment_to_mostrarFragment3, miBundle1)
            }
            v.setOnLongClickListener {

                val miBundle2: Bundle = bundleOf("id" to this.posicion)
                fragmento.findNavController().navigate(R.id.action_FirstFragment_to_modificarFragment, miBundle2)





                val miBundle: Bundle = bundleOf("id" to this.posicion)
                fragmento.findNavController().navigate(R.id.action_FirstFragment_to_modificarFragment, miBundle)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.layout_contenedor, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.myimage, null)
        holder.titulo.text = listaLibros[position].titulo
        holder.autor.text = listaLibros[position].autor
        holder.posicion=position
    }


    override fun getItemCount(): Int {
        return 10
    }


}