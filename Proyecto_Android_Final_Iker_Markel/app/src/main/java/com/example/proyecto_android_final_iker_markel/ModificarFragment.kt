package com.example.proyecto_android_final_iker_markel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.proyecto_android_final_iker_markel.databinding.FragmentModificarBinding

class ModificarFragment : Fragment() {
    private var _binding: FragmentModificarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentModificarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id:Int=arguments?.getInt("id") ?:-1

        if(binding.ModTitulo.text.isNotEmpty() &&
            binding.ModAutor.text.isNotEmpty() &&
            binding.ModGenero.text.isNotEmpty() &&
            binding.ModFecha.text.isNotEmpty()) {
            if (binding.ModTitulo.text.toString() != (activity as MainActivity).miViewModel.listaLibros[id].titulo ||
                binding.ModAutor.text.toString() != (activity as MainActivity).miViewModel.listaLibros[id].autor ||
                binding.ModGenero.text.toString() != (activity as MainActivity).miViewModel.listaLibros[id].genero ||
                binding.ModFecha.text.toString().toInt() != (activity as MainActivity).miViewModel.listaLibros[id].fecha) {
                (activity as MainActivity).miViewModel.modificarLibro(id.toString(), binding.ModTitulo.text.toString(),
                    binding.ModAutor.text.toString(), binding.ModGenero.text.toString(),  binding.ModFecha.text.toString().toInt())

                Toast.makeText(activity,"Libro editado", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_modificarFragment_to_FirstFragment)
            }
        }

        binding.ModModificar.setOnClickListener {
            findNavController().navigate(R.id.action_mostrarFragment3_to_FirstFragment)
        }


    }

}