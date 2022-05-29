package com.example.proyecto_android_final_iker_markel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.currentCoroutineContext

class VM : ViewModel() {

    var listaLibros: MutableList<Libro> = mutableListOf()

    init {
        actualizarLista()
    }

     fun insertarLibro(titulo: String, autor: String, genero: String, fecha: Int) {

        val objeto = ParseObject("Libros")
        objeto.put("Titulo", titulo)
        if (autor != null) {
            objeto.put("Autor", autor)
        }
        objeto.put("Genero", genero)
        objeto.put("Fecha", fecha)
        objeto.saveInBackground {

        }
    }

    fun eliminarLibro(id: String) {

        val query = ParseQuery.getQuery<ParseObject>("Libros")
        query.whereEqualTo("objectId", id)
        query.getFirstInBackground { parseObject, parseException ->
            if (parseException == null) {
                parseObject.deleteInBackground {
                }
            }
        }
    }

    fun modificarLibro(
        libro: Libro
    ) {
        val query = ParseQuery.getQuery<ParseObject>("Libros")
        query.whereEqualTo("objectId", libro.id)
        query.getFirstInBackground { parseObject, parseException ->
            if (parseException == null) {
                parseObject.put("Titulo", libro.titulo)
                parseObject.put("Autor", libro.autor)
                parseObject.put("Genero", libro.genero)
                parseObject.put("Fecha", libro.fecha)
                parseObject.saveInBackground {
                }
            }
        }
    }

    fun listarLibros(): MutableList<Libro>  {
        val ll: MutableList<Libro> = mutableListOf()
        val query = ParseQuery<ParseObject>("Libros")
        query.orderByAscending("Titulo")
        val lista = query.find()
        for (i in lista){
            val temp: Libro = Libro(
                i.objectId,
                i.getString("Titulo"),
                i.getString("Autor"),
                i.getString("Genero"),
                i.getInt("Fecha")
            )
            ll.add(temp)
        }
        return ll
    }

    fun actualizarLista(){
        listaLibros = listarLibros()
    }
}