package com.example.proyecto_android_final_iker_markel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.InserTitulo.
        binding.InserAutor.
        binding.InserGenero.
        binding.InserFecha.
        binding.Inser.isVisible=true

        binding.InserInsert.setOnClickListener {
            findNavController().navigate(R.id.action_mostrarFragment3_to_FirstFragment)
        }


    }


}