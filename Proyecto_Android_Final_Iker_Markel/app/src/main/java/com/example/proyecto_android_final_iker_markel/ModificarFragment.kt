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

        (activity as MainActivity).supportActionBar?.title = "Modificar libro"

        val id: Int = arguments?.getInt("id") ?: -1
        var libroSelec = (activity as MainActivity).miViewModel.listaLibros[id]

        binding.ModTitulo.setText(libroSelec.titulo)
        binding.ModAutor.setText(libroSelec.autor)
        binding.ModGenero.setText(libroSelec.genero)
        binding.ModFecha.setText(libroSelec.fecha.toString())


        binding.ModModificar.setOnClickListener {
            if (binding.ModTitulo.text.isNotEmpty() &&
                binding.ModAutor.text.isNotEmpty() &&
                binding.ModGenero.text.isNotEmpty() &&
                binding.ModFecha.text.isNotEmpty()
            ) {
                if (binding.ModTitulo.text.toString() != (activity as MainActivity).miViewModel.listaLibros[id].titulo) {
                    (activity as MainActivity).miViewModel.listaLibros[id].titulo =
                        binding.ModTitulo.text.toString()
                }
                if (binding.ModAutor.text.toString() != (activity as MainActivity).miViewModel.listaLibros[id].autor) {
                    (activity as MainActivity).miViewModel.listaLibros[id].autor =
                        binding.ModAutor.text.toString()
                }
                if (binding.ModGenero.text.toString() != (activity as MainActivity).miViewModel.listaLibros[id].genero) {
                    (activity as MainActivity).miViewModel.listaLibros[id].genero =
                        binding.ModGenero.text.toString()
                }
                if (binding.ModFecha.text.toString()
                        .toInt() != (activity as MainActivity).miViewModel.listaLibros[id].fecha
                ) {
                    (activity as MainActivity).miViewModel.listaLibros[id].fecha =
                        binding.ModFecha.text.toString().toInt()
                }

                (activity as MainActivity).miViewModel.modificarLibro((activity as MainActivity).miViewModel.listaLibros[id])
                Toast.makeText(activity, "Libro editado", Toast.LENGTH_LONG).show()
                (activity as MainActivity).miViewModel.actualizarLista()
                findNavController().navigate(R.id.action_modificarFragment_to_FirstFragment)
            } else {
                Toast.makeText(activity, "Debes rellenar todos los campos", Toast.LENGTH_SHORT)
                    .show()
            }
        }


    }

}