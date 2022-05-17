package com.example.proyecto_android_final_iker_markel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.currentCoroutineContext

class VM : ViewModel() {

    var listaLibros: MutableList<Libro> = mutableListOf()

    init{
        listaLibros.add(Libro("jdDG1Kpq1w","El quijote","Anonimo", "Ficcion",1605))
    }

    public fun insertarLibro(titulo: String, autor: String, genero: String, fecha: Int) {

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
        id: String,
        titulo: String,
        autor: String,
        genero: String,
        fecha: Int
    ) {
        val query = ParseQuery.getQuery<ParseObject>("Libros")
        query.whereEqualTo("objectId", id)
        query.getFirstInBackground { parseObject, parseException ->
            if (parseException == null) {
                if (titulo != null) {
                    parseObject.put("Titulo", titulo)
                }
                if (autor != null) {
                    parseObject.put("Autor", autor)
                }
                if (genero != null) {
                    parseObject.put("Genero", genero)
                }
                if (fecha != null) {
                    parseObject.put("Fecha", fecha)
                }
                parseObject.saveInBackground {
                }
            }
        }
    }

    fun listarLibros() : MutableList<Libro> {
        val ll: MutableList<Libro> = mutableListOf()
        val query = ParseQuery<ParseObject>("Libros")
        query.orderByDescending("Titulo")
        query.findInBackground { objects: List<ParseObject>, e ->
            if (e == null) {
                for (i in objects) {
                    val temp: Libro = Libro(
                        i.objectId,
                        i.getString("Titulo"),
                        i.getString("Autor"),
                        i.getString("Genero"),
                        i.getInt("Fecha")
                    )
                    ll.add(temp)
                }
            }
        }
        return ll
    }
}