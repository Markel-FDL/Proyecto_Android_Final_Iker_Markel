package com.example.proyecto_android_final_iker_markel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


}