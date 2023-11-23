package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.uf1_proyecto.databinding.FragmentIntroduceBinding

class IntroduceFragment : Fragment() {

    var _binding : FragmentIntroduceBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_introduce, container, false)
        _binding = FragmentIntroduceBinding.inflate(inflater,container,false)
        var view = binding.root

        binding.buttonInicial.setOnClickListener {
            view.findNavController().navigate(R.id.action_introduceFragment_to_inicialiteFragment)
        }
        binding.buttonRegist.setOnClickListener {
            view.findNavController().navigate(R.id.action_introduceFragment_to_registerFragment)
        }
        return view
    }

}