package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.uf1_proyecto.databinding.FragmentIntroduceBinding
import com.example.uf1_proyecto.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    var _binding : FragmentRegisterBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_introduce, container, false)
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        var view = binding.root
        binding.buttonStart.setOnClickListener {
            if (!binding.password.text.toString().equals(binding.repitPassword.text.toString())) {
                Toast.makeText(
                    activity,
                    "La contraseña no es correcta. No son iguales",
                    Toast.LENGTH_LONG
                ).show()
                binding.password.setText("")
                binding.repitPassword.setText("")
            }
        }
        return view
    }
}