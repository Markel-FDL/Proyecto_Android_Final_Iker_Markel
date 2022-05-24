package com.example.proyecto_android_final_iker_markel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.proyecto_android_final_iker_markel.databinding.FragmentMostrarBinding


class MostrarFragment : Fragment() {

    private var _binding: FragmentMostrarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMostrarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Datos libro"

        val id:Int=arguments?.getInt("id") ?:-1

            binding.VerTitulo.setText((activity as MainActivity).miViewModel.listaLibros[id].titulo)
            binding.VerAutor.setText((activity as MainActivity).miViewModel.listaLibros[id].autor)
            binding.VerGenero.setText((activity as MainActivity).miViewModel.listaLibros[id].genero)
            binding.VerFecha.setText((activity as MainActivity).miViewModel.listaLibros[id].fecha.toString())
            binding.VerVolver.isVisible=true

        binding.VerVolver.setOnClickListener {
            findNavController().navigate(R.id.action_mostrarFragment3_to_FirstFragment)
        }

        binding.eliminar.setOnClickListener{
            (activity as MainActivity).miViewModel.eliminarLibro((activity as MainActivity).miViewModel.listaLibros[id].id)
            findNavController().navigate(R.id.action_mostrarFragment3_to_FirstFragment)
        }
    }
}