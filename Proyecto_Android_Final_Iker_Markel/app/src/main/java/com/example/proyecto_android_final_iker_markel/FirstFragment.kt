package com.example.proyecto_android_final_iker_markel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_android_final_iker_markel.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var miRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).miViewModel.actualizarLista()
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Lista de libros"

        miRecyclerView = binding.Contenedores
        miRecyclerView.layoutManager = LinearLayoutManager(activity)
        miRecyclerView.adapter = Adaptador(this, (activity as MainActivity).miViewModel.listaLibros)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_insertarFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        (activity as MainActivity).miViewModel.actualizarLista()
        miRecyclerView.adapter?.notifyDataSetChanged()

        super.onResume()
    }
}