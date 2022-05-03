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

class Adaptador(var fragmento: Fragment, ): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    class ViewHolder (v: View):RecyclerView.ViewHolder(v){
        var titulo: ImageView =v.findViewById(R.id.Titulo)
        var autor: TextView =v.findViewById(R.id.Autor)
        init{
            v.setOnClickListener {
                val miBundle: Bundle = bundleOf("id" to this.posicion)
                fragmento.findNavController().navigate(R.id.action_SecondFragment_to_detalleFragment, miBundle)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.layout_contenedor, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: Adaptador.ViewHolder, position: Int) {
        holder.titulo.text=
        holder.autor.text=
    }

    override fun getItemCount(): Int {
        return 10
    }


}