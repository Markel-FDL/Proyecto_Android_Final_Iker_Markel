package com.example.proyecto_android_final_iker_markel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.currentCoroutineContext

class VM : ViewModel() {

    private fun insertarLibro(titulo: String, autor: String, genero: String, fecha: Int) {

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

    private fun eliminarLibro(id: String) {

        val query = ParseQuery.getQuery<ParseObject>("Libros")
        query.whereEqualTo("objectId", id)
        query.getFirstInBackground { parseObject, parseException ->
            if (parseException == null) {
                parseObject.deleteInBackground {
                }
            }
        }
    }

    private fun modificarLibro(
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
}