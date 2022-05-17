package com.example.proyecto_android_final_iker_markel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.proyecto_android_final_iker_markel.databinding.FragmentInsertarBinding


class InsertarFragment : Fragment() {

    private var _binding: FragmentInsertarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInsertarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.InserInsert.setOnClickListener {

            if (binding.InserTitulo.text.isNotEmpty() &&
                binding.InserAutor.text.isNotEmpty() &&
                binding.InserGenero.text.isNotEmpty() &&
                binding.InserFecha.text.isNotEmpty()
            ) {
                (activity as MainActivity).miViewModel.insertarLibro(
                    binding.InserTitulo.text.toString(), binding.InserAutor.text.toString(),
                    binding.InserGenero.text.toString(), binding.InserFecha.text.toString().toInt()
                )
                Toast.makeText(activity, "Libro insertado", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_insertarFragment_to_FirstFragment)

            }


        }

    }
}