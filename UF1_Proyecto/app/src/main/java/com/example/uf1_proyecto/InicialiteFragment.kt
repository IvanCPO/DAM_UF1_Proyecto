package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import com.example.uf1_proyecto.databinding.FragmentInicialiteBinding

class InicialiteFragment : Fragment() {


    var _binding : FragmentInicialiteBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInicialiteBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.buttonRegister.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicialiteFragment_to_registerFragment)
        }
        binding.buttonAccept.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicialiteFragment_to_testFragment)
        }
        return view

    }

}